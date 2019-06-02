package Project.eshops.Dao;

import java.util.List;

import Project.eshops.Model.CartItem;

public interface CartItemDAO 
{
	public boolean addCart(CartItem cart);
	public boolean deleteCart(CartItem cart);
	public boolean updateCart(CartItem cart);
	public CartItem getCart(int cartItemId);
	public List<CartItem> listCartItems(String username);
	
	
	
	
	
	
}
