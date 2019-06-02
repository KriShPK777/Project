package Project.eshops.Dao;

import java.util.List;

import Project.eshops.Model.Category;

public interface CategoryDAO 
{
  public boolean addcategory(Category category);
  public boolean deletecategory(Category category);
  public boolean updatecategory(Category category);
  public Category getCategory(int categoryId);
  public List<Category> listCategories();
  
}
