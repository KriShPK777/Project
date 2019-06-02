package Project.eshops.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Supplier 
{
	@Id
	@GeneratedValue
	int SupplierId;
	String Suppliername;
	String SupplierDesc;
	public int getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(int supplierId) {
		SupplierId = supplierId;
	}
	public String getSuppliername() {
		return Suppliername;
	}
	public void setSuppliername(String suppliername) {
		Suppliername = suppliername;
	}
	public String getSupplierDesc() {
		return SupplierDesc;
	}
	public void setSupplierDesc(String supplierDesc) {
		SupplierDesc = supplierDesc;
	}
	
}
