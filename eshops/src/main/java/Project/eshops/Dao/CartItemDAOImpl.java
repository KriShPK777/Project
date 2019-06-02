package Project.eshops.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Project.eshops.Model.CartItem;
import Project.eshops.Model.CustomerOrder;
import Project.eshops.Model.UserDetail;

@Repository("cartItemDAO")
@Transactional

public class CartItemDAOImpl implements CartItemDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCart(CartItem cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
		
	}	

	@Override
	public boolean deleteCart(CartItem cart) 
	{

		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean updateCart(CartItem cart) 
	{ 

		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public CartItem getCart(int cartItemId) 
	{
		Session session=sessionFactory.openSession();
		CartItem cart=(CartItem) session.get(CartItem.class, cartItemId);
		session.close();
		return cart;
	}	
	@Override
	public List<CartItem> listCartItems(String username) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CartItem");
		query.setString(0,username);
		@SuppressWarnings("unchecked")
		List<CartItem> listcartItems=query.list();
		return listcartItems;
	
}
}
