package SpringDB.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SpringDB.model.ApparelCrud;
import SpringDB.model.HistoryCrud;
import SpringDB.model.UserCrud;
import SpringDB.schema.Apparel;
import SpringDB.schema.History;
import SpringDB.schema.Users;
import SpringDB.service.Buy;
import SpringDB.service.Order;

@Controller
public class UserController {

	@Autowired
	UserCrud uc;

	@Autowired
	ApparelCrud ac;

	@Autowired
	HistoryCrud hc;

	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("/SignUp.jsp");
		return mv;
	}

	// If an user has been authenticated, he/she will be displayed the apparels that he bought
	@RequestMapping("/purchases")
	public String all(Model m) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = "";
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			email = authentication.getName();
		}
		Users u = uc.findByEmail(email).orElse(new Users());
		m.addAttribute("apparels", u.getAp());
		return "templates/Purchases";
	}

	// Automatically redirect to the login page after registering as new user
	@RequestMapping(value = "/signup/submit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView signUpSubmit(Users u) {
		uc.save(u);
		ModelAndView mv = new ModelAndView("redirect:" + "/login");
		return mv;
	}

	// If an user has been authenticated, he/she will be displayed all the items in the store to choose from
	@RequestMapping("/user")
	public ModelAndView userHome() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = "";
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			email = authentication.getName();
		}
		Users u = uc.findByEmail(email).orElse(new Users());
		List<Apparel> l = ac.findAll();
		History h = u.getH();
		if (h != null && h.getN() >= h.getS())
			l = ac.findAllByOrderByTypeAsc();
		else
			l = ac.findAllByOrderByTypeDesc();
		ModelAndView mv = new ModelAndView("/Market.jsp");
		mv.addObject("apparels", l);
		return mv;
	}

	// Search items (gets list of apparels)
	@RequestMapping("/user/Search")
	public ModelAndView search(@RequestParam("search") String search) {
		ModelAndView mv = new ModelAndView("/Market.jsp");
		List<Apparel> l = ac.findBySearch(search);
		mv.addObject("apparels", l);
		return mv;
	}

	// Sort by increasing or decreasing order of price of apparels
	@RequestMapping("/user/Sort")
	public ModelAndView sort(@RequestParam("order") String order) {
		ModelAndView mv = new ModelAndView("/Market.jsp");
		List<Apparel> l = null;
		if (order.equals("ASC"))
			l = ac.findAllByOrderByPriceAsc();
		else if (order.equals("DESC"))
			l = ac.findAllByOrderByPriceDesc();
		System.out.println(l);
		mv.addObject("apparels", l);
		return mv;
	}

	// Checks history of user (whether Seasonal or New-Arrival)
	@RequestMapping("/user/his")
	public void history() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = "";
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			email = authentication.getName();
		}
		Users u = uc.findByEmail(email).orElse(new Users());
		Order o = new Order();
		o.set(u);
	}

	// On clicking the 'buy' button, added that apparel to that user's shopping history
	@RequestMapping("/user/buy")
	public ModelAndView buy(@RequestParam("id") int aid) {
		Apparel a = ac.findById(aid).orElse(new Apparel());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = "";
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			email = authentication.getName();
		}
		Users u = uc.findByEmail(email).orElse(new Users());
		Buy b = new Buy();
		u = b.buy(a, u);
		uc.save(u);
		History h = u.getH();
		hc.save(h);
		ModelAndView mv = new ModelAndView("redirect:" + "/user");
		return mv;
	}

	// Show all buyable apparels for that user
	@RequestMapping("/user/purchases")
	public ModelAndView findAll() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = "";
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			email = authentication.getName();
		}
		Users u = uc.findByEmail(email).orElse(new Users());
		ModelAndView mv = new ModelAndView("/Purchases.jsp");
		mv.addObject("apparels", u.getAp());
		return mv;
	}
}
