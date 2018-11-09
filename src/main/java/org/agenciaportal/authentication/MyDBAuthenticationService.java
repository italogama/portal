package org.agenciaportal.authentication;

import java.util.HashSet;
import java.util.Set;
import org.agenciaportal.entity.Account;
import org.agenciaportal.entity.Role;
import org.agenciaportal.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyDBAuthenticationService implements UserDetailsService{

	@Autowired
    private AccountDao accountDAO;
 
    @Override
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountDAO.findAccount(username);
        if (account == null) {
            throw new  UsernameNotFoundException("Usuario "+username+" não foi encontrado");
        }
 
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : account.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
      
        boolean enabled = account.isActive();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        UserDetails userDetails = (UserDetails) new User(account.getUserName(), 
                account.getPassword(), enabled, accountNonExpired, 
                credentialsNonExpired, accountNonLocked, grantedAuthorities);
 
        return userDetails;
    }

}
