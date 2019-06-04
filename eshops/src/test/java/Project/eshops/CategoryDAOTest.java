package Project.eshops;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Project.eshops.Dao.CategoryDAO;
import Project.eshops.Model.Category;

public class CategoryDAOTest 
{
     static CategoryDAO categoryDAO;
     @BeforeClass
     public static void executeFirst()
     {
	   @SuppressWarnings("resource")
	   AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext();
	   context.scan("Project"); 
	   context.refresh();
	   
	   categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
     }
	//@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		Category.setCategoryname("TShirt");
		Category.setCategoryDesc("T-Shirt with round neck collar of all brands");
		
		assertTrue("problem in Adding Category",categoryDAO.addcategory(category));
		
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		
		assertTrue("problem in Deleting Category",categoryDAO.addcategory(category));
			
	}
	//@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		Category.setCategoryname("Raymond Shirt");
		
		assertTrue("problem in Updating Category",categoryDAO.addcategory(category));
	}
	@Ignore
	@Test
	public void listCategoryTest()
	{
		List<Category> categoryList=categoryDAO.listCategories();
		
		assertTrue("problem in Listing Categories",categoryList.size()>0);
		
		for(Category category:categoryList)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryname()+":::");
			System.out.println(category.getCategoryDesc());
			
			
		}
		
	}
	}


