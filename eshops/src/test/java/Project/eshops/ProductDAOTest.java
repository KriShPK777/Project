package Project.eshops;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Project.eshops.Dao.ProductDAO;
import Project.eshops.Model.Product;

public class ProductDAOTest 
{
  
	static ProductDAO productDAO;
    @BeforeClass
    public static void executeFirst()
    {
      
    	@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext();
    	context.scan("Project.eshops");
    	context.refresh();
    	
    	 productDAO=(ProductDAO)context.getBean("productDAO");
    	
    }
    
    @Test
    public void addProductTest()
    {
    	@SuppressWarnings("rawtypes")
		Product product=new Product();
    	product.setProductname("Raymond Formal");
    	product.setProductDesc("Formal shirt with neck with excellent colour");
    	product.setPrice(900);
    	product.setStock(40);
    	product.setCategoryId(3);
    	product.setSupplierId(2);
    	
    	assertTrue("problem in Adding Category",productDAO.addProduct(product));
    }
    @Ignore
    @Test
    public void deleteProductTest()
    {
    	@SuppressWarnings("rawtypes")
		Product product=productDAO.getProduct(2);
    	assertTrue("problem in Deleting Category",ProductDAO.deleteProduct(product));
    }
    
    @Ignore
    @Test
    public void updateProductTest()
    {
    	@SuppressWarnings("rawtypes")
		List<Product> productList=productDAO.getProductList();
    	
    	assertTrue("problem in Listing Products",productList.size()>0);
    	
    	for(@SuppressWarnings("rawtypes") Product product:productList)
    	{
    		
    		System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductname()+":::");
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductname()+":::");
    	}
		
    }
    	
    	
}
