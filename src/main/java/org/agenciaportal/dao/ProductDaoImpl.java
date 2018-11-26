package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.Product;
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
		public List <Product> listProducts() {
			Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Product.class);
	        return crit.list(); 
		}

		@Override
		public void deleteProduct(String typeId) {
			Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Product.class);
	        crit.add(Restrictions.eq("code", typeId));
	       
			session.delete((Product) crit.uniqueResult());
		}

		@Override
		public Product saveProduct(String code, String name, long price, int quantity, long product_type_id) {
			Session session = sessionFactory.getCurrentSession();
			Product p = new Product();
			
			p.setCode(code);
			p.setName(name);
			p.setPrice(price);
			p.setQuantity(quantity);
			ProductType pt = new ProductType();
			pt.setId(product_type_id);
			p.setProductType(pt);
			session.save(p);
			
			return p;
		}

		@Override
		public ProductType saveProductType(Long id, String alias, String description) {
			Session session = sessionFactory.getCurrentSession();
			ProductType pt = new ProductType();
			
			pt.setId(id);
			pt.setAlias(alias);
			pt.setDescription(description);
			session.save(pt);
			
			return pt;
		}

}
