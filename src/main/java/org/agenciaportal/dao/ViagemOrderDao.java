package org.agenciaportal.dao;

import java.util.List;
import java.util.Date;

import org.agenciaportal.entity.ViagemOrder;

public interface ViagemOrderDao {
	public ViagemOrder saveOrder(String code,int quantity,Date x, Date x2, String username);
	 
    public List<ViagemOrder> getOrdersByUserName(String username);

    
}
