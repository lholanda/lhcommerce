package nl.lhdev.lhcommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nl.lhdev.lhcommerce.entities.User;
import nl.lhdev.lhcommerce.projections.UserDetailsProjection;

public interface UserRepository extends JpaRepository<User, Long> {

     // projecao --- """ para escrever SELECT em mais de uma linha
    @Query(nativeQuery = true, value = """
			SELECT tb_user.email AS username, tb_user.password, 
                   tb_role.id AS roleId, tb_role.authority
			FROM tb_user
			INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id
			INNER JOIN tb_role ON tb_role.id = tb_user_role.role_id
			WHERE tb_user.email = :email
		""")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

}
