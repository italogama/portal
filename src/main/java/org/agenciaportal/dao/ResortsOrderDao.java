package org.agenciaportal.dao;

import java.util.Date;
import java.util.List;

import org.agenciaportal.entity.ResortsOrder;

public interface ResortsOrderDao {
	public ResortsOrder saveOrder(String code,int quantity,Date x, Date x2, String username);
	 
    public List<ResortsOrder> getOrdersByUserName(String username);

    
}

