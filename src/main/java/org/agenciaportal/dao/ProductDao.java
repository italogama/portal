package org.agenciaportal.dao;

import java.util.Date;
import java.util.List;

import org.agenciaportal.entity.Product;
import org.agenciaportal.entity.ProductType;

public interface ProductDao {

	public Product findProduct(String code);
	
    public List<Product> getAllProductsByType(Long typeId);
    
    public List<Product> getAllProductsByAlias(String alias);
    
    public List<Product> listProducts();
    
	void deleteProduct(String typeId);
	
	public Product saveProduct(String code, String name,long price,int quantity, long product_type_id);
	
	public ProductType saveProductType(Long id, String alias, String description);
	

	
   
}
