package org.agenciaportal.dao;

import java.util.Date;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.agenciaportal.entity.Account;
import org.agenciaportal.entity.ViagemOrder;
import org.agenciaportal.entity.Viagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ViagemOrderDaoImpl implements ViagemOrderDao {

	@Autowired
    private SessionFactory sessionFactory;
 
    @Autowired
    private ViagemDao viagensDAO;
    
    @Autowired
    private AccountDao accountDao;
 
    private int getMaxOrderNum() {
        String sql = "Select max(o.orderNum) from " + ViagemOrder.class.getName() + " o ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        Integer value = (Integer) query.uniqueResult();
        if (value == null) {
            return 0;
        }
        return value;
    }
 
    @Override
    public ViagemOrder saveOrder(String code,int quantity, Date x, Date x2, String username) {
        Session session = sessionFactory.getCurrentSession();

        int orderNum = this.getMaxOrderNum() + 1;
       
        Account account = accountDao.findAccount(username); 
        Viagens product = viagensDAO.findProduct(code);
        product.setQuantity(product.getQuantity()-quantity);
        ViagemOrder order = new ViagemOrder();
        order.setOrderNum(orderNum);
        order.setOrderDate(new Date());
        order.setGoDate(x);
        order.setBackDate(x2);
        order.setAmount(quantity * (product.getPrice()));
        order.setQuantity(quantity);
        order.setAccount(account);
        order.setProduct(product);
        session.save(order);
       
        return order;
    }
 
    /*// @page = 1, 2, ...
    @Override
    public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
        String sql = "Select new " + OrderInfo.class.getName()//
                + "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
                + " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
                + Order.class.getName() + " ord "//
                + " order by ord.orderNum desc";
        Session session = this.sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
 
        return new PaginationResult<OrderInfo>(query, page, maxResult, maxNavigationPage);
    }*/
 
    public ViagemOrder findOrder(String orderId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(ViagemOrder.class);
        crit.add(Restrictions.eq("id", orderId));
        return (ViagemOrder) crit.uniqueResult();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<ViagemOrder> getOrdersByUserName(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Account account =accountDao.findAccount(username); 
        Criteria crit = session.createCriteria(ViagemOrder.class);
        crit.add(Restrictions.eq("account.userId", account.getUserId()));
        List<ViagemOrder> list = (List<ViagemOrder>) crit.list();
        /*list.forEach(Order::getProduct);*/
		return list;
	}
 
   

}
