package Project.eshops.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table
public class Category {
@Id
@GeneratedValue
int CategoryId;
static String Categoryname;
static String CategoryDesc;
public int getCategoryId() {
	return CategoryId;
}
public void setCategoryId(int categoryId) {
	CategoryId = categoryId;
}
public String getCategoryname() {
	return Categoryname;
}
public static void setCategoryname(String categoryname) {
	Categoryname = categoryname;
}
public String getCategoryDesc() {
	return CategoryDesc;
}
public static void setCategoryDesc(String categoryDesc) {
	CategoryDesc = categoryDesc;
}


}
