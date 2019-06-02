package Project.eshops.Dao;

import java.util.List;

import Project.eshops.Model.Category;
import Project.eshops.Model.Supplier;

public interface SupplierDAO 
{
	public boolean addcategory(Supplier supplier);
	public boolean deletecategory(Supplier supplier);
	public boolean updatecategory(Supplier supplier);
	public Category getCategory(int supplierId);
	public List<Category> listCategories();
	  
}
