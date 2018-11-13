package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

	 	@Autowired
	    private SessionFactory sessionFactory;
	 
	    @Override
	    public Product findProduct(String code) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Product.class);
	        crit.add(Restrictions.eq("code", code));
	       
	        return (Product) crit.uniqueResult();
	    }

		@SuppressWarnings("unchecked")
		@Override
		public List<Product> getAllProductsByType(Long typeId) {
			 Session session = sessionFactory.getCurrentSession();
		     Criteria crit = session.createCriteria(Product.class);
		     crit.add(Restrictions.eq("productType.id", typeId));
			return crit.list();
		}

		@Override
		public List<Product> getAllProductsByAlias(String alias) {
			 Session session = sessionFactory.getCurrentSession();
		     Criteria crit = session.createCriteria(Product.class);
		     Criteria cType = crit.createCriteria("productType");
		     cType.add(Restrictions.eq("alias", alias));
			return crit.list();
		}

		@Override
		public List <Product> listarProdutosAdm() {
			Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Product.class);
	        return crit.list();
		}

}
