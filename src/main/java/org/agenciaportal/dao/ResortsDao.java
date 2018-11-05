package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.Resorts;

public interface ResortsDao {

	public Resorts findProduct(String code);
    public List<Resorts> getAllProducts();
   
}