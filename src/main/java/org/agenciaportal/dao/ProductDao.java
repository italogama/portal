package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.Product;

public interface ProductDao {

	public Product findProduct(String code);
    public List<Product> getAllProducts();
   
}
