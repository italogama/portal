package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.ProductType;

public interface ProductTypeDao {
	
	ProductType getById(Long id);
	ProductType getByAlias(String alias);
	List<ProductType> list();

}
