package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Entities.Audio;
import Entities.Image;
import Entities.Location;
import Entities.Text;
import Entities.Trip;
import Entities.User;
import Entities.Video;
import data.AdminDAO;
import data.LoginDAO;
import data.TravelDAO;
import data.adminUser;

@Controller
@SessionAttributes(
{ "user" })
public class AdminController
{

	@Autowired
	private LoginDAO loginDAO;
	@Autowired
	private TravelDAO travelDAO;
	@Autowired
	private AdminDAO adminDAO;
	public static String USERNAME;

	@RequestMapping(path = "editAccount.do", method = RequestMethod.POST)
	public ModelAndView createTrip(@RequestParam("username") String username)
	{
		System.out.println("inside creating new trip method");
		ModelAndView mv = new ModelAndView();
		User user = loginDAO.getUserByUsername(username);
		mv.addObject("user", user);
		mv.setViewName("editUser.jsp");
		
		return mv;
	}
	
	@RequestMapping(path = "updateUserDB.do", method = RequestMethod.POST)
	public ModelAndView updateUserinDB(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("email") String email)
	{

		System.out.println("inside method to submit data to database");
		System.out.println("username :" + username + " password " + password + " " + email);

		ModelAndView mv = new ModelAndView();

		User user = loginDAO.getUserByUsername(username);

		user.setEmail(email);
		user.setPassword(password);
		
		adminDAO.updateUser(user);
		
		mv.setViewName("GetUserTravel.do");
			return mv;

		}
	
	@RequestMapping(path = "adminDashboard.do", method = RequestMethod.GET)
	public ModelAndView adminDashboard()
	{

		ModelAndView mv = new ModelAndView();


		List<User> alluser =adminDAO.getALLUser();
		mv.setViewName("adminView.jsp");
		mv.addObject("allusers", alluser);
		
		mv.setViewName("adminView.jsp");
			return mv;

		}


	

@RequestMapping(path = "deleteAccount.do", method = RequestMethod.POST)
public ModelAndView deleteUser(@RequestParam("username") String username)
{

	ModelAndView mv = new ModelAndView();
	User user = loginDAO.getUserByUsername(username);

	adminDAO.removeUser(user);
	
	List<User> alluser =adminDAO.getALLUser();
	mv.setViewName("adminView.jsp");
	mv.addObject("allusers", alluser);
	
	mv.setViewName("adminView.jsp");
		return mv;

	}


}

	


