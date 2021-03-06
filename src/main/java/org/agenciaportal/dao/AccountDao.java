package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.Account;

public interface AccountDao {
	public Account findAccount(String userName);
	public void saveAccount(Account account);
	public void saveAccountAdm(Account account);
	List<Account> listUsers();
	
	void deleteUser(Long userId);
}
