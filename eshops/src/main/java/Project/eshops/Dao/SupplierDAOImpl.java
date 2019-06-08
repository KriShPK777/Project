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
	public boolean addSupplier(Project.eshops.Model.Supplier supplier) 
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
	public boolean deleteSupplier(Project.eshops.Model.Supplier supplier) 
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
	public boolean updateSupplier(Project.eshops.Model.Supplier supplier) 
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
	public List<Supplier> listSuppliers() 
	{ 
		Session session=sessionFactory.openSession();
		List<Category>ListCategory=(List<Category>)session.createQuery("from Category").list();
    	session.close();
    	return listSuppliers();
		
	}

}
