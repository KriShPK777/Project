package Project.eshops.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetail 
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  int orderId;
  String username;
  Date orderDate;
  int shoppingAmount;
  String pmode;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public int getShoppingAmount() {
	return shoppingAmount;
}
public void setShoppingAmount(int shoppingAmount) {
	this.shoppingAmount = shoppingAmount;
}
public String getPmode() {
	return pmode;
}
public void setPmode(String pmode) {
	this.pmode = pmode;
}
	
	
	
	
}
