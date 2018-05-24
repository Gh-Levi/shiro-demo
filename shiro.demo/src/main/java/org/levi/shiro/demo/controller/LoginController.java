package org.levi.shiro.demo.controller;

import org.levi.shiro.demo.biz.LoginBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LoginBiz loginBiz;
	
	@RequestMapping("/toLogin.shtml")
	public ModelAndView test() {
		
		ModelAndView moAndView = new ModelAndView();
		moAndView.setViewName("login");
		return moAndView;
	}
	
	@RequestMapping("/doLogin.shtml")
	public void doLogin(String username,String password) {
		loginBiz.doLogin(username, password);
	}

}
