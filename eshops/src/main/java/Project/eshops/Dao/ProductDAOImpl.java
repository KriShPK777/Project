package Project.eshops.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Project.eshops.Model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
	    catch(Exception e)
		{
		return false;
	}

	}		
	public boolean deleteProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}

	}
	@Override
	public boolean updateProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
        catch(Exception e)
		{
		return false;
	}

	}	
	@Override
	public List<Product> getProductList() 
	{
		Session session=sessionFactory.openSession();
		Query query=(Query) session.createQuery("from Product");
		List<Product> productList=((org.hibernate.Query) query).list();
		session.close();
		return productList;
		
	}

	@Override
	public List<Product> getProductListCategoryWise(int categoryId) 
	{
		Session session=sessionFactory.openSession();
		Query query=(Query) session.createQuery("from Product where categoryId=catId");
		query.setParameter("catId", categoryId);
		List<Product> productList=((org.hibernate.Query) query).list();
		session.close();
		return productList;
		
	}

	@Override
	public Product getProduct(int productId) 
	{
	 	
		Session session=sessionFactory.openSession();
		Product product=(Product) session.get(Product.class,productId);
		session.close();
		return product;
		
	}
	

	
	
}
