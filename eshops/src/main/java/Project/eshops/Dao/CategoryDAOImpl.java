package Project.eshops.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Project.eshops.Model.Category;

@Repository("categoryDAO")
@Transactional
public abstract class CategoryDAOImpl implements CategoryDAO
{
	
    @Autowired
    SessionFactory sessionFactory;
    
    
    public List<Category> ListCategories()
    {
    	Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Category>ListCategory=(List<Category>)session.createQuery("from Category").list();
    	session.close();
    	return ListCategory;
    }
    
	@Override
	public boolean addcategory(Project.eshops.Model.Category category) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	@Override
	public boolean deletecategory(Project.eshops.Model.Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
		
	}
	

	@Override
	public boolean updatecategory(Project.eshops.Model.Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}

	}
	@Override
	public Project.eshops.Model.Category getCategory(int categoryId) 
	{		
		Session session=sessionFactory.openSession();
	    Category category=(Category) session.get(Category.class,categoryId);
	    session.close();
	    return category;
	}

}