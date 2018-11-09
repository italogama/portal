package org.agenciaportal.dao;

import java.util.List;
import java.util.Date;

import org.agenciaportal.entity.Order;

public interface ProductOrderDao {
	public Order saveOrder(String code,int quantity,Date x, Date x2, String username);
	 
    public List<Order> getOrdersByUserName(String username);

    
}
