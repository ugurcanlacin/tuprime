package com.ugurcanlacin.sportclubsystem.dao;

import com.ugurcanlacin.sportclubsystem.model.Role;


public interface RoleDao {
	void persistRole(Role role);
	void updateRole(Role role);
	void deleteRole(Role role);
	Role getRoleById(int id);
}
