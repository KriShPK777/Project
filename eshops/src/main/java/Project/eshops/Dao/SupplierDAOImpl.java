package Project.eshops.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Project.eshops.Model.Category;
import Project.eshops.Model.Supplier;

@Repository("SupplierDAO")
@Transactional

public class SupplierDAOImpl implements SupplierDAO
{


    @Autowired
    SessionFactory sessionFactory;
    
	@Override
	public boolean addcategory(Project.eshops.Model.Supplier supplier) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}

	}		
	@Override
	public boolean deletecategory(Project.eshops.Model.Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
		
		return false;
	}

	}		
	@Override
	public boolean updatecategory(Project.eshops.Model.Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
		
		return false;
	}

	}		
	public Supplier getSupplier(int supplierId) 
	{
		Session session=sessionFactory.openSession();
	    Supplier supplier=(Supplier) session.get(Supplier.class,supplierId);
	    session.close();
		return supplier;
	}

	@Override
	public List<Category> listCategories() 
	{
		Session session=sessionFactory.openSession();
		List<Category>ListCategory=(List<Category>)session.createQuery("from Category").list();
    	session.close();
    	return ListCategory;
		
	}
	@Override
	public Category getCategory(int supplierId) 
	{
		Session session=sessionFactory.openSession();
	    Category supplier=(Category) session.get(Supplier.class,supplierId);
	    session.close();
		return supplier;
		
	}

}
