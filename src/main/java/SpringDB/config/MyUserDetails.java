package SpringDB.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import SpringDB.schema.Users;

public class MyUserDetails implements UserDetails {

	int userId;
	String userName;
	String password;
	String gender;
	private List<GrantedAuthority> authorities; // List of roles of users that are authenticated

	public MyUserDetails() {
	}

	// Instantiates the username
	public MyUserDetails(String uname) {
		this.userName = uname;
	}

	/**
	 * 
	 * @param u
	 *          Overrides prev method to fetch user details
	 *          authorities => gets list of comma-separated roles of the
	 *          authenticated users
	 */
	public MyUserDetails(Users u) {
		userId = u.getUserId();
		userName = u.getEmail();
		password = u.getPassword();
		gender = u.getGender();
		authorities = Arrays.stream(u.getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		System.out.println(authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
