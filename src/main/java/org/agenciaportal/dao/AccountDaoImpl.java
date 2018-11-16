package org.agenciaportal.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.agenciaportal.entity.Account;
import org.agenciaportal.entity.Product;
import org.agenciaportal.entity.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AccountDaoImpl implements AccountDao{

	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
	private RoleDao roleDao;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
 
    @Override
    public Account findAccount(String userName ) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Account.class);
        crit.add(Restrictions.eq("userName", userName));
        return (Account) crit.uniqueResult();
    }

	@Override
	public void saveAccount(Account account) {
		 Set<Role> roles = new HashSet<>();
		 roles.add(roleDao.findRoleByRoleNAme("USER"));
		 System.out.println("ROLES --------------"+roles);
		 account.setRoles(roles);
		 Session session = sessionFactory.getCurrentSession();
		 account.setActive(true);
		 account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		 session.save(account);
	}
	
	@Override
	public List <Account> listUsers() {
		Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Account.class);
        return crit.list();
	}
	
}
