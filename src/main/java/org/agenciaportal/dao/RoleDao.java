package org.agenciaportal.dao;

import java.util.List;

import org.agenciaportal.entity.Role;

public interface RoleDao {

	public Role findRoleByRoleNAme(String role);
	public List<Role> findRoleAll();
}
