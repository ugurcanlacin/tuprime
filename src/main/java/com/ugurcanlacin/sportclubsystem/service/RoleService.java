package com.ugurcanlacin.sportclubsystem.service;

import com.ugurcanlacin.sportclubsystem.model.Role;

public interface RoleService extends GenericService<Role>{
	Role getRoleById(int id);
}
