package eshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Project.eshops.Dao.CartItemDAO;
import Project.eshops.Dao.ProductDAO;
import Project.eshops.Dao.UserDAO;
import Project.eshops.Model.CartItem;
import Project.eshops.Model.Product;
import Project.eshops.Model.UserDetail;

@Controller
public class CartController 
{
  @Autowired
  CartItemDAO cartDAO;
  
  @Autowired
  ProductDAO productDAO;
  
  @Autowired
  UserDAO userDAO;
  
  @RequestMapping("/updateAddress")
  public String updateAddress(@RequestParam("address")String address,String username,Model m,HttpSession session)
  {
	  String username1=(String)session.getAttribute("username");
	  List<CartItem> listCartItems=cartDAO.listCartItems(username);
	  UserDetail user=userDAO.getUserDetail(username);
	  user.setAddress(address);
	  userDAO.updateUser(user);
	  m.addAttribute("cartItems", listCartItems);
	  m.addAttribute("grandTotal", this.calcGrandTotal(listCartItems));
	  m.addAttribute("addr", user.getAddress());
	  
	  return "OrderConfirm";
	  
  }
  
  
  

  @RequestMapping("/addToCart/(productId)")
  public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,Model m)
  {
	  Product product=productDAO.getProduct(productId);
	  
	  String username="sam";
	  CartItem cart=new CartItem();
	  cart.setProductId(product.getProductId());
	  cart.setProductName(product.getProductname());
	  cart.setQuantity(quantity);
	  cart.setPrice(product.getPrice());
	  cart.setStatus("NP");
	  
	  cartDAO.addCart(cart);
	  
	  List<CartItem> listCartItems=cartDAO.listCartItems(username);
	  m.addAttribute("cartItems", listCartItems);
	  m.addAttribute("grandTotal", this.calcGrandTotal(listCartItems));
	  
	  return "Cart";
	 	  
  }
  @RequestMapping("/deleteCartItem/{cartItemId)")
  public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m)
  {
	  CartItem cart=cartDAO.getCart(cartItemId);
	  cartDAO.deleteCart(cart);
	  
	  String username="sam";
	  
	  
	  List<CartItem> listCartItems=cartDAO.listCartItems(username);
	  m.addAttribute("cartItems", listCartItems);
	  m.addAttribute("grandTotal", this.calcGrandTotal(listCartItems));
	  
	  return "Cart";
	  
	  		  
  }
  @RequestMapping("/updateCartItem/{cartItemId)")
  public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m)
  {
	  CartItem cart=cartDAO.getCart(cartItemId);
	  cart.setQuantity(quantity);
	  
	  cartDAO.updateCart(cart);
	  
	  String username="sam";
	  
	  List<CartItem> listCartItems=cartDAO.listCartItems(username);
	  m.addAttribute("cartItems", listCartItems);
	  m.addAttribute("grandTotal", this.calcGrandTotal(listCartItems));
	  
	  return "Cart";
  }
	  
  public int calcGrandTotal(List<CartItem> listCartItems)
  {
	 
	  int count=0,grandTotal=0;
	  while(count<listCartItems.size())
		  
	  {
		  grandTotal=grandTotal+(listCartItems.get(count).getQuantity()*listCartItems.get(count).getPrice());
		  count++;
		 
	  }
	  return grandTotal;
  }
  
  
  
  
  
  
  
  
}	
	
	
	

