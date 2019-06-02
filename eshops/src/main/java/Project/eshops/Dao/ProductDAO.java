package Project.eshops.Dao;

import java.util.List;

import Project.eshops.Model.Product;

public interface ProductDAO 
{
  public boolean addProduct(Product product);
  public static boolean deleteProduct(Product product) {

	return false;
}
  public boolean updateProduct(Product product);
  public List<Product> getProductList();
  public List<Product> getProductListCategoryWise(int categoryId);
  Product getProduct(int productId);
  

}
