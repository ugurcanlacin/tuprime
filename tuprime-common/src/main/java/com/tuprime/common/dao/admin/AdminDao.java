package com.tuprime.common.dao.admin;

import com.tuprime.common.dao.generic.GenericDao;
import com.tuprime.entities.Admin;

public interface AdminDao extends GenericDao<Admin>{
	public Admin loadAdmin(String username);
}
