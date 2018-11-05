package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.Resorts;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ResortsDaoImpl implements ResortsDao {

	 	@Autowired
	    private SessionFactory sessionFactory;
	 
	    @Override
	    public Resorts findProduct(String code) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Resorts.class);
	        crit.add(Restrictions.eq("code", code));
	        return (Resorts) crit.uniqueResult();
	    }
	 
	    
	 

		@SuppressWarnings("unchecked")
		@Override
		public List<Resorts> getAllProducts() {
			 Session session = sessionFactory.getCurrentSession();
		     Criteria crit = session.createCriteria(Resorts.class);
			return crit.list();
		}

}

