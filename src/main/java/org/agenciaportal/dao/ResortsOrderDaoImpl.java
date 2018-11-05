package org.agenciaportal.dao;

import java.util.Date;
import java.util.List;

import org.agenciaportal.entity.Account;
import org.agenciaportal.entity.ResortsOrder;
import org.agenciaportal.entity.Resorts;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ResortsOrderDaoImpl implements ResortsOrderDao {

	@Autowired
    private SessionFactory sessionFactory;
 
    @Autowired
    private ResortsDao resortsDAO;
    
    @Autowired
    private AccountDao accountDao;
 
    private int getMaxOrderNum() {
        String sql = "Select max(o.orderNum) from " + ResortsOrder.class.getName() + " o ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        Integer value = (Integer) query.uniqueResult();
        if (value == null) {
            return 0;
        }
        return value;
    }
 
    @Override
    public ResortsOrder saveOrder(String code,int quantity, Date x, Date x2, String username) {
        Session session = sessionFactory.getCurrentSession();

        int orderNum = this.getMaxOrderNum() + 1;
       
        Account account = accountDao.findAccount(username); 
        Resorts product = resortsDAO.findProduct(code);
        product.setQuantity(product.getQuantity()-quantity);
        ResortsOrder order = new ResortsOrder();
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
 
    public ResortsOrder findOrder(String orderId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(ResortsOrder.class);
        crit.add(Restrictions.eq("id", orderId));
        return (ResortsOrder) crit.uniqueResult();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<ResortsOrder> getOrdersByUserName(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Account account =accountDao.findAccount(username); 
        Criteria crit = session.createCriteria(ResortsOrder.class);
        crit.add(Restrictions.eq("account.userId", account.getUserId()));
        List<ResortsOrder> list = (List<ResortsOrder>) crit.list();
		return list;
	}
 
   

}

