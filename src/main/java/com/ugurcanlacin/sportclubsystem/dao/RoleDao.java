package com.ugurcanlacin.sportclubsystem.dao;

import java.util.List;

import com.ugurcanlacin.sportclubsystem.model.Role;


public interface RoleDao extends GenericDao<Role>{
	Role getRoleById(int id);
	List<Role> getAllRoles();
	Role getRoleByName(String roleName);
}
