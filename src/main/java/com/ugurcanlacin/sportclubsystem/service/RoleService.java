package com.ugurcanlacin.sportclubsystem.service;

import java.util.List;

import com.ugurcanlacin.sportclubsystem.model.Role;

public interface RoleService extends GenericService<Role>{
	Role getRoleById(int id);
	List<Role> getAllRoles();
	Role getRoleByName(String roleName);
}
