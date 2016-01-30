package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.LoadCardsDAO;
import data.LoadDeckDAO;
import data.Card;

@Controller
public class LoadCardsController {
	@Autowired
	private LoadCardsDAO LoadCardsDAO;
	@Autowired
	private LoadDeckDAO LoadDeckDAO;

	@RequestMapping(path = "getcards.do", method = RequestMethod.GET)
	public ModelAndView basic(@RequestParam("set") String s) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list.jsp");
		mv.addObject("card", LoadCardsDAO.getCardList(s));
		return mv;
	}

	@RequestMapping(path = "makedeck.do", method = RequestMethod.GET)
	public ModelAndView deckClassChoice(@RequestParam("class") String c) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("setselect.jsp");
		mv.addObject("clazz", c);
		return mv;
	}

	@RequestMapping(path = "getclasscards.do", method = RequestMethod.GET)
	public ModelAndView basic(@RequestParam("set") String s, @RequestParam("class") String c) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addtodeck.jsp");
		mv.addObject("card", LoadCardsDAO.getCardList(s,c));
		try {
		LoadDeckDAO.getDeck();
		mv.addObject("deckcard", LoadDeckDAO.getDeck());
	}
		catch (Exception e) { 
		}
		mv.addObject("clazz", c);
		mv.addObject("set", s);
		return mv;
	}

	@RequestMapping(path = "addtodeck.do", method = RequestMethod.GET)
	public ModelAndView addCards(@RequestParam("add") String n, @RequestParam("class") String l,
			@RequestParam("set") String s) {
		LoadDeckDAO.addCard(n);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addtodeck.jsp");
		mv.addObject("card", LoadCardsDAO.getCardList(s, l));
		mv.addObject("deckcard", LoadDeckDAO.getDeck());
		mv.addObject("clazz", l);
		mv.addObject("set", s);
		return mv;
	}
	@RequestMapping(path = "deletefromdeck.do", method = RequestMethod.GET)
	public ModelAndView deleteCards(@RequestParam("delete") String n, @RequestParam("class") String l,
			@RequestParam("set") String s) {
		LoadDeckDAO.deleteCard(n);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addtodeck.jsp");
		mv.addObject("card", LoadCardsDAO.getCardList(s, l));
		mv.addObject("deckcard", LoadDeckDAO.getDeck());
		mv.addObject("clazz", l);
		mv.addObject("set", s);
		return mv;
	}
}
