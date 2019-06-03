package eshop.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Project.eshops.Dao.ProductDAO;
import Project.eshops.Model.Product;

@Controller
public class UserController 
{
	@Autowired
	ProductDAO productDAO;
	
	
	
    @RequestMapping("/login_sucess")
    public String loginSucess(HttpSession session,Model m)
    {
    	System.out.println("I am in login Success");
    	
    	String page="";
    	boolean loggedIn=false;
    	
    	SecurityContext sContext=SecurityContextHolder.getContext();
    	Authentication authentication=sContext.getAuthentication();
    	
    	String username=authentication.getName();
    	
    	Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
    			
    	for(GrantedAuthority role:roles)
    	{
    		if (role.getAuthority().equals("ROLE_ADMIN"))
    		{
    			loggedIn=true;
    			page="AdminHome";
    			session.setAttribute("loggedIn", loggedIn);
    			session.setAttribute("username", username);
    		}
    		else
    		{
    			List<Product> productList=productDAO.getProductList();
    			m.addAttribute("productList", productList);
    			loggedIn=true;
    			page="UserHome";
    			session.setAttribute("loggedIn", loggedIn);
    			session.setAttribute("username", username);
    		}
    	}
    	
    	return "Page";
    	
    }
	
}
