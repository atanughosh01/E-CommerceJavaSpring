package SpringDB.service;

import java.util.Set;
import org.springframework.stereotype.Service;
import SpringDB.schema.Apparel;
import SpringDB.schema.Users;

@Service
public class Buy {

	/**
	 * 
	 * @param a
	 * @param u
	 * @return Users
	 * 
	 *         If user buys an apparel, associate it with the user and set the order
	 *         type according to the items bought
	 */
	public Users buy(Apparel a, Users u) {
		Order o = new Order();
		Set<Apparel> ap = u.getAp();
		ap.add(a);
		u.setAp(ap);
		if (a.getType().equals("Seasonal"))
			o.seasonal(u);
		else
			o.newArrival(u);
		return u;
	}
}
