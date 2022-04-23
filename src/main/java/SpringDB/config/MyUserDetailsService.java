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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = uc.findByEmail(username).orElse(new Users());
		return new MyUserDetails(user);
	}
}
