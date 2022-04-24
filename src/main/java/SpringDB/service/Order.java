package SpringDB.service;

import org.springframework.stereotype.Service;
import SpringDB.schema.History;
import SpringDB.schema.Users;

@Service
public class Order {

	/**
	 * 
	 * @param u
	 *          If the user has no history (neither seasonal nor new-arrival),
	 *          create a new history and set the user accordingly
	 * 
	 */
	public void set(Users u) {
		History h = null;
		if (u.getH() == null) {
			h = new History();
			u.setH(h);
			h.setU(u);
		}
	}

	/**
	 * 
	 * @param u
	 * @return Users
	 * 
	 *         For seasonal items, create the item, increment the count, and set the
	 *         user type as seasonal
	 */
	public Users seasonal(Users u) {
		set(u);
		History h = u.getH();
		h.incS();
		u.setH(h);
		return u;
	}

	/**
	 * 
	 * @param u
	 * @return Users
	 * 
	 *         For new-arrival items, create the item, increment the count, and set
	 *         the user type as new-arrival
	 */
	public Users newArrival(Users u) {
		set(u);
		History h = u.getH();
		h.incN();
		u.setH(h);
		return u;
	}
}
