package org.agenciaportal.dao;

import java.util.List;
import org.agenciaportal.entity.Order;

public interface OrderDao {
	public Order saveOrder(String code,int quantity,String username);
	 
    public List<Order> getOrdersByUserName(String username);
    
}
