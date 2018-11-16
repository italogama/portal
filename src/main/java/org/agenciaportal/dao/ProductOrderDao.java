package org.agenciaportal.dao;

import java.util.List;
import java.util.Date;

import org.agenciaportal.entity.Order;

public interface ProductOrderDao {
	public Order saveOrder(String code, String type,int quantity,Date ida, Date volta, String username);
	 
    public List<Order> getOrdersByUserName(String username);

	public List<Order> listOrders();

    
}
