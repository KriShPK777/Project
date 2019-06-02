package Project.eshops.Dao;

import Project.eshops.Model.OrderDetail;

public interface OrderDAO 
{
	public boolean paymentProcess(OrderDetail orderDetail);
	public boolean updateCartItems(String username,int orderId);
}
