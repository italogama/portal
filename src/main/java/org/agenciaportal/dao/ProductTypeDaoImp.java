package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.Order;
import org.agenciaportal.entity.ProductType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProductTypeDaoImp implements ProductTypeDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public ProductType getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(ProductType.class);
        crit.add(Restrictions.eq("id", id));
        return (ProductType) crit.uniqueResult();
	}
	
	@Override
	public ProductType getByAlias(String alias) {
		Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(ProductType.class);
        crit.add(Restrictions.eq("alias", alias));
        return (ProductType) crit.uniqueResult();
	}

	@Override
	public List<ProductType> list() {
		Session session = sessionFactory.getCurrentSession();
		 Criteria crit = session.createCriteria(ProductType.class);
		return crit.list();
	}

}
