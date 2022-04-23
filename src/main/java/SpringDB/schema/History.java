package SpringDB.schema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int n = 0;
	private int s = 0;

	/**
	 * n/N => denotes items of type : NEW ARRIVAL
	 * s/S => denotes items of type : SEASONAL
	 */

	@OneToOne
	@JoinColumn(name = "userId")
	private Users user;

	public History() { }

	public void incN() {
		n++;
	}

	public void incS() {
		s++;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public Users getU() {
		return user;
	}

	public void setU(Users u) {
		this.user = u;
	}
}
