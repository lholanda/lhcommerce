package nl.lhdev.lhcommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.lhdev.lhcommerce.entities.User;
import nl.lhdev.lhcommerce.projections.UserDetailsProjection;
import nl.lhdev.lhcommerce.repositories.UserRepository;


@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // faz uma consulta diferente, mas evitamos mudar FETCH
        List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
        if (result.size() == 0) {
            throw new UsernameNotFoundException("User not found !");
        }

        User user = new User();

        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());

        // result.stream().map(projection -> new Role(projection.getRoleId(), projection.getAuthority()))
        //         .forEach(user::addRole);

        return user;
    }
}
