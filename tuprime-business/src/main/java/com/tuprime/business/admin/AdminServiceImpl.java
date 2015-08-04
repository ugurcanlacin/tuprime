package com.tuprime.business.admin;

import com.tuprime.business.generic.GenericServiceImpl;
import com.tuprime.common.business.admin.AdminService;
import com.tuprime.common.dao.admin.AdminDao;
import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.entities.Admin;

public class AdminServiceImpl extends GenericServiceImpl<Admin> implements AdminService{

	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public GenericDao<Admin> getDao() {
		return getAdminDao();
	}

	@Override
	public Admin loadAdmin(String username) {
		return getAdminDao().loadAdmin(username);
	}
	

}
