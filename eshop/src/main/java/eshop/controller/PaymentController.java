package eshop.controller;

import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Project.eshops.Dao.CartItemDAO;
import Project.eshops.Dao.OrderDAO;
import Project.eshops.Dao.UserDAO;
import Project.eshops.Model.CartItem;
import Project.eshops.Model.OrderDetail;
import Project.eshops.Model.UserDetail;

@Controller
public class PaymentController 
{
  @Autowired
  CartItemDAO cartDAO;
  
  @Autowired
  UserDAO userDAO;
  
  @Autowired
  OrderDAO orderDAO;
  
  @RequestMapping("/checkout")
  public String showOrderConfirmPage(Model m)
  {
	  String username="sam";
	  List<CartItem> listCartItems=cartDAO.listCartItems(username);
	  m.addAttribute("cartItems", listCartItems);
	  m.addAttribute("grandTotal",this.calcGrandTotal(listCartItems));
	  
	  UserDetail user=userDAO.getUserDetail(username);
	  m.addAttribute("addr",user.getAddress());
	  return "OrderConfirm";
  }
  @RequestMapping("/payment")
  public String showPaymentPage(Model m)
  {
	  String username="sam";
	  List<CartItem> listCartItems=cartDAO.listCartItems(username);
	  m.addAttribute("cartItems", listCartItems);
	  m.addAttribute("grandTotal",this.calcGrandTotal(listCartItems));
	  
	  return "Payment";
	  
  }
  
  @RequestMapping(value="/updateAddr",method=RequestMethod.POST)
  public String UpdateAddress(@RequestParam("addr")String addr,Model m)
  {
	  String username="sam";
	  List<CartItem> listCartitems=cartDAO.listCartItems(username);
	  m.addAttribute("cartItems", listCartitems);
	  m.addAttribute("grandTotal",this.calcGrandTotal(listCartitems));
	  
	  UserDetail user=userDAO.getUserDetail(username);
	  user.setAddress(addr);
	  userDAO.updateUser(user);
	  
	  return "orderconfirm";	  
  }
	
  @RequestMapping(value="/pay",method=RequestMethod.POST)
  public String generateReceipt(@RequestParam("pmode")String pmode,Model m)
{

	  String username="sam";
	  List<CartItem> listCartitems=cartDAO.listCartItems(username);
	  int grandTotal=this.calcGrandTotal(listCartitems);
	  m.addAttribute("grandTotal", grandTotal);
	  
	  OrderDetail order=new OrderDetail();
	  order.setShoppingAmount(grandTotal);
	  order.setUsername(username);
	  order.setOrderDate(new java.util.Date());
	  order.setPmode(pmode);
	  order.setShoppingAmount(grandTotal);
	  
	  orderDAO.paymentProcess(order);
	  orderDAO.updateCartItems(username, grandTotal);
	  
	  m.addAttribute("orderinfo", order);
	  m.addAttribute("address", userDAO.getUserDetail(username));
	  
	  return "Receipt";	
}
  public int calcGrandTotal (List<CartItem> listCartItems)
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