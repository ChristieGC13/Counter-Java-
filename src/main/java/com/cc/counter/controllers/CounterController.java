package com.cc.counter.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("count", 0);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count = count + 1;
		session.setAttribute("count", count);
		return "counter.jsp";
	}
	
	@RequestMapping("/clearCounter")
	public String clear(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
