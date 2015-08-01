package com.tuprime.common.business.role;


import java.util.List;

import com.tuprime.common.business.generic.GenericService;
import com.tuprime.entities.Role;


public interface RoleService extends GenericService<Role>{
	Role getRoleById(int id);
	List<Role> getAllRoles();
	Role getRoleByName(String roleName);
}
