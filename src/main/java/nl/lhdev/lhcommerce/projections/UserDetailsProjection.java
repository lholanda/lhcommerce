package nl.lhdev.lhcommerce.projections;

public interface UserDetailsProjection {

    String getUsername();
	String getPassword();
	Long getRoleId();
	String getAuthority();

}
