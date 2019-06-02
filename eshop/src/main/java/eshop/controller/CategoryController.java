package eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Project.eshops.Dao.CategoryDAO;
import Project.eshops.Model.Category;

@Controller
public class CategoryController 
{
    @Autowired
	CategoryDAO categoryDAO;
	private String Categoryname;
	private String categoryDesc;
    
    @RequestMapping(value="/category")
    public String showCategoryPage(Model m)
    {
      List<Category> categoryList=categoryDAO.listCategories();
      m.addAttribute("categoryList",categoryList);
      return "category";
      
    }
    
    @SuppressWarnings("static-access")
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
    public String insertCategory(@RequestParam("categoryName")String categoryName, @RequestParam("categoryDesc")String categoryDesc,Model m)
    {
	 Category category=new Category();
	 category.setCategoryname(categoryName);
	 category.setCategoryDesc(categoryName);
	 
	 categoryDAO.addcategory(category);
	 
	 List<Category> categoryList=categoryDAO.listCategories();
	 m.addAttribute("categoryList",categoryList);
	 return "Category";
    }
    
    @RequestMapping(value="/editCategory/(categoryId)")
    public String editCategory(@PathVariable("catgeoryId")int categoryId, Model m)
    {
    	Category category= categoryDAO.getCategory(categoryId);
    	m.addAttribute("category",category);
    	
    	 List<Category> categoryList=categoryDAO.listCategories();
    	 m.addAttribute("categoryList",categoryList);
    	
        return "Category";
	 
    }
    
    @RequestMapping(value="/deleteCategory/(categoryId)")
    public String deleteCategory(@PathVariable("catgeoryId")int categoryId, Model m)
    {
    	Category category= categoryDAO.getCategory(categoryId);
    	categoryDAO.deletecategory(category);
    	
    	 List<Category> categoryList=categoryDAO.listCategories();
    	 m.addAttribute("categoryList",categoryList);
		return "Category";

		
    }
    
    @SuppressWarnings("static-access")
	@RequestMapping(value="/updateCategory/(categoryId)",method=RequestMethod.POST)
    public String updateCategory(@PathVariable("catgeoryId")int categoryId, Model m)
    {
    	Category category= categoryDAO.getCategory(categoryId);
    	category.setCategoryname(Categoryname);
    	category.setCategoryDesc(categoryDesc);
    	
    	categoryDAO.updatecategory(category);

   	 List<Category> categoryList=categoryDAO.listCategories();
   	 m.addAttribute("categoryList",categoryList);
    	
    	
		return "Category";
    	
   	 
    	
    	
    	
    	
    }
	 
	 
	 
	
}
