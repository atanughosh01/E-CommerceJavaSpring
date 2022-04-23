package SpringDB.schema;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;
	String name;
	String email;
	String password;
	String gender;
	private String role;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private History h;

	public History getH() {
		return h;
	}

	public void setH(History h) {
		this.h = h;
	}

	public Set<Apparel> getAp() {
		return ap;
	}

	public void setAp(Set<Apparel> ap) {
		this.ap = ap;
	}

	@ManyToMany
	@JoinTable(name = "purchases")
	@JoinColumn(name = "user_id")
	Set<Apparel> ap;

	public Users() {
	}

	public int getUserId() {
		return userId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
