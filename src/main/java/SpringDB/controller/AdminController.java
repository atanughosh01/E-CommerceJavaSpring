package SpringDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SpringDB.model.ApparelCrud;
import SpringDB.schema.Apparel;

@Controller
public class AdminController {

	/**
	 * The @Autowired annotation marks a Constructor, Setter method, Properties and
	 * Config() method as to be autowired that is ‘injecting beans'(Objects)
	 * at runtime by Spring Dependency Injection mechanism
	 */
	@Autowired
	ApparelCrud ac;

	/**
	 * RequestMapping is one of the basic annotations in Spring
	 * which maps HTTP requests (URLs) with methods
	 */
	@RequestMapping("/admin")
	public ModelAndView Add() {
		ModelAndView mv = new ModelAndView("/Add.jsp");
		List<Apparel> l = ac.findAll();
		mv.addObject("apparels", l);
		return mv;
	}

	// Testing
	@RequestMapping("/admin/hello")
	public void display() {
		System.out.println("whhy");
	}

	// Adds a new item for display on clicking AddApparel
	@RequestMapping(value = "/admin/addApparel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView Submit(Apparel ap) {
		ac.save(ap);
		ModelAndView mv = new ModelAndView("/Add.jsp");
		List<Apparel> l = ac.findAll();
		mv.addObject("apparels", l);
		return mv;
	}

	// Deletes the item on clicking DeleteApparel
	@RequestMapping("/admin/deleteApparel")
	public ModelAndView delete(@RequestParam("id") int id) {
		ac.deleteById(id);
		ModelAndView mv = new ModelAndView("/Add.jsp");
		List<Apparel> l = ac.findAll();
		mv.addObject("apparels", l);
		return mv;
	}

	// Gets the admin-searched item(s) if the searched string is a substring of any
	// of the listed item-details set by the admin itself
	@RequestMapping("/admin/Search")
	public ModelAndView search(@RequestParam("search") String search) {
		ModelAndView mv = new ModelAndView("/Add.jsp");
		List<Apparel> l = ac.findBySearch(search);
		mv.addObject("apparels", l);
		return mv;
	}
}
