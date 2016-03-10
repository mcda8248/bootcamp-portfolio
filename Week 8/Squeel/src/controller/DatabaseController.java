package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.DatabaseDAO;

@Controller
public class DatabaseController {
	@Autowired
	private DatabaseDAO DatabaseDAO;
	
	@RequestMapping(path = "getquery.do", method = RequestMethod.GET)
	public ModelAndView query(@RequestParam("query") String s) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("query.jsp");
		mv.addObject("results", DatabaseDAO.getQuery(s));
		return mv;
	}
	
	@RequestMapping(path = "doupdate.do", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("update") String s) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update.jsp");
		mv.addObject("numUpdates", DatabaseDAO.doUpdate(s));
		return mv;
	}
}
