package com.ugurcanlacin.sportclubsystem.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.ugurcanlacin.sportclubsystem.dao.RoleDao;
import com.ugurcanlacin.sportclubsystem.model.Role;
import com.ugurcanlacin.sportclubsystem.service.RoleService;
@Transactional
public class RoleServiceImpl implements RoleService{
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
	
}
