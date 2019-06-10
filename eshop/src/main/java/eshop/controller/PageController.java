package eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{
	@RequestMapping("/")
	public String showIndex()
	{
		return "index";
		
	}
	
  @RequestMapping(value="/login")
  public String showLoginPage()
  {
	  
	  return "Login";
  }
  @RequestMapping(value="/Register")
  public String showRegisterPage()
  {
	  return "Register";
  }
	
  @RequestMapping("/AboutUs")
  public String showAboutUs()
  {
	  return "AboutUs";
  }
}
