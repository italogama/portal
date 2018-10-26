package org.agenciaportal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.agenciaportal.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

	 	@Autowired
	    private SessionFactory sessionFactory;
	 
	    @Override
	    public Products findProduct(String code) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Products.class);
	        crit.add(Restrictions.eq("code", code));
	        return (Products) crit.uniqueResult();
	    }
	 
	    
	 

		@SuppressWarnings("unchecked")
		@Override
		public List<Products> getAllProducts() {
			 Session session = sessionFactory.getCurrentSession();
		     Criteria crit = session.createCriteria(Products.class);
			return crit.list();
		}

}
