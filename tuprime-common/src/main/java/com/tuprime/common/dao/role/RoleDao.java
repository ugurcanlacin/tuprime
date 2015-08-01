package com.tuprime.common.dao.role;


import java.util.List;

import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.entities.Role;



public interface RoleDao extends GenericDao<Role>{
	Role getRoleById(int id);
	List<Role> getAllRoles();
	Role getRoleByName(String roleName);
}
