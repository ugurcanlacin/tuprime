package com.ugurcanlacin.sportclubsystem.dao;

import com.ugurcanlacin.sportclubsystem.model.Role;


public interface RoleDao extends GenericDao<Role>{
	Role getRoleById(int id);
}
