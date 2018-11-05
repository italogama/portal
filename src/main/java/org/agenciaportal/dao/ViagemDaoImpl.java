package org.agenciaportal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.agenciaportal.entity.Viagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ViagemDaoImpl implements ViagemDao {

	 	@Autowired
	    private SessionFactory sessionFactory;
	 
	    @Override
	    public Viagens findProduct(String code) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Viagens.class);
	        crit.add(Restrictions.eq("code", code));
	        return (Viagens) crit.uniqueResult();
	    }
	 
	    
	 

		@SuppressWarnings("unchecked")
		@Override
		public List<Viagens> getAllProducts() {
			 Session session = sessionFactory.getCurrentSession();
		     Criteria crit = session.createCriteria(Viagens.class);
			return crit.list();
		}

}
