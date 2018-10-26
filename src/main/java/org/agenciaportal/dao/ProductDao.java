package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.Products;

public interface ProductDao {

	public Products findProduct(String code);
    public List<Products> getAllProducts();
   
}
