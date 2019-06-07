package eshop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Project.eshops.Dao.CategoryDAO;
import Project.eshops.Dao.ProductDAO;
import Project.eshops.Model.Product;

@Controller

public class ProductController 
{
	 @Autowired
     ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
     
     public ProductController()
     {
     System.out.println("ProductController Bean is Created");
    		
     }
     
     @RequestMapping(value="/all/getallproducts")
     public String getAllProducts(Model model)
     {
  
		List<Product> products=productDAO.getProductList();
    	 model.addAttribute("productsList",products);
    	 return "listofproducts";
    	 	 
     }
	
     @RequestMapping(value="/all/getproduct/{id}")
     public String getProduct(@PathVariable int id,Model model)
     {
    	
		Product product=productDAO.getProduct(id);
    		model.addAttribute("productObj",product);
    		return "viewproduct";
    	   	 
     }
	
     @RequestMapping(value="/deleteproduct/{productid}")
     public String deleteProduct(@PathVariable int id,Model model,HttpServletRequest request, int productId)
     {
    	 
		Product product=productDAO.getProduct(productId);
    	 
    	 productDAO.deleteProduct(product);
    		Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+id+".png");
    		if(Files.exists(path))
    		{
    			try 
    			{
    				Files.delete(path);
    			} 
    			catch (IOException e) 
    			{
    				e.printStackTrace();
    				
    			}	
    	 
    		}
    		return "redirect:/all/getallproducts";
    	 
     }
	  
     @RequestMapping(value="/admin/getproductform")
     public String getproductform(Model model)
     {
    	 
    	
		Product p=new Product();
         model.addAttribute("product",p);
         model.addAttribute("categories",productDAO.getProductList());
    	 
         return "productform";
    	 
     }
     
     @RequestMapping(value="/admin/addproduct")
     public String addProduct(@Validated @ModelAttribute(value="product") Product product,BindingResult result,Model model ,HttpServletRequest request)
     {
    	 if(result.hasErrors())
    	 {
    		 model.addAttribute("categories",productDAO.getProductList());
    			return "productform";
    	 }
     
    	 productDAO.addProduct(product);
    		
    		Object img=product.getImage();
    		System.out.println(request.getServletContext().getRealPath("/"));
    		Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getImage()+".png");
    		if(!((MultipartFile) img).isEmpty()&&img!=null)
    		{
    			try 
    			{
    				((MultipartFile) img).transferTo(new File(path.toString()));
    			} 
    			catch (IllegalStateException e) 
    			{
    			
    				e.printStackTrace();
    			} 
    			catch (IOException e) 
    			{
    				
    				e.printStackTrace();
    			}
    		}
    		
    		return "redirect:/all/getallproducts";
    	 
    	 
     }
     
     @RequestMapping(value="/admin/getupdateform/{id}")
     public String getUpdateProductForm(@PathVariable int id,Model model)
     {
     
     	
		Product product=productDAO.getProduct(id);
     	model.addAttribute("product",product);
     	model.addAttribute("categories",productDAO.getProductList());
     	return "updateproductform";
     }
     
     @RequestMapping(value="/admin/updateproduct")
     public String updateProduct(@Validated @ModelAttribute Product product,BindingResult result,Model model,HttpServletRequest request)
     {
    	 
    	 if(result.hasErrors())
    	 {
    		   model.addAttribute("categories",productDAO.getProductList());
    		   return "updateproductform";
   	 
     }
      
    	 productDAO.updateProduct(product);
    	MultipartFile img=(MultipartFile) product.getImage();
    	System.out.println(request.getServletContext().getRealPath("/"));
    	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getImage()+".png");
    	if(!img.isEmpty()&&img!=null)
    	{
    		try 
    		{
    			img.transferTo(new File(path.toString()));
    		} 
    		catch (IllegalStateException e) 
    		{
    			
    			e.printStackTrace();
    		} 
    		catch (IOException e)
    		{
    			
    			e.printStackTrace();
    		}
    	}
    	return "redirect:/all/getallproducts";
    }
    	 
     @RequestMapping(value="/all/searchByCategory")
     public String searchByCategory(@RequestParam String searchCondition ,Model model)
     {
     	if(searchCondition.equals("All"))
     		model.addAttribute("searchCondition","");
     	else
     	model.addAttribute("searchCondition",searchCondition);
     	model.addAttribute("productsList",productDAO.getProductList());
     	return "listofproducts";
    	 
    	 
     } 	 
     
}


