package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.Viagens;

public interface ViagemDao {

	public Viagens findProduct(String code);
    public List<Viagens> getAllProducts();
   
}
