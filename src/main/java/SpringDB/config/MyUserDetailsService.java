package SpringDB.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SpringDB.model.UserCrud;
import SpringDB.schema.Users;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserCrud uc;

	/**
	 * @param username
	 *                 Searches the DB to get the User by Corresponding User Mail ID
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// Users user = uc.findByEmail(username).orElse(new Users());
		Users user = uc.findByEmail(username).orElse(null);
		if (user == null)
			throw new UsernameNotFoundException(username);
		return new MyUserDetails(user);
	}
}
