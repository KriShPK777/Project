package eshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController 
{
    @RequestMapping("/login_sucess")
    public String loginSucess(HttpSession session,Model m)
    {
    	System.out.println("I am in login Success");
    	
    	String page="";
    	boolean loggedIn=false;
    	
    	SecurityContext sContext=SecurityContextHolder.getContext();
    	Authentication authentication=sContext.getAuthentication();
    	
    	
    	return "ProductPage";
    	
    }
	
}
