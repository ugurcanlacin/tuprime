package com.tuprime.business.role;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tuprime.business.generic.GenericServiceImpl;
import com.tuprime.common.business.role.RoleService;
import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.common.dao.role.RoleDao;
import com.tuprime.entities.Role;

@Transactional
public class RoleServiceImpl extends GenericServiceImpl<Role> implements RoleService{
	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public Role getRoleById(int id) {
		return roleDao.getRoleById(id);
	}

	@Override
	public GenericDao<Role> getDao() {
		return getRoleDao();
	}

	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

	public Role getRoleByName(String roleName) {
		return roleDao.getRoleByName(roleName);
	}
	
}
