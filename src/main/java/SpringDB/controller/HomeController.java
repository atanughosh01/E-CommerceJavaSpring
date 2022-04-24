package SpringDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import SpringDB.model.UserCrud;

@Controller
public class HomeController {

	@Autowired
	UserCrud u;

	@RequestMapping({ "/home", "/" })
	public String display() {
		return "Home.jsp";
	}

	// If not logged-in, deny the user to access any information and redirect to the
	// error 403 page
	@RequestMapping("accessdenied")
	public String unauthenticated() {
		return "Unauthenticated.jsp";
	}
}
