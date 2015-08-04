package com.tuprime.common.business.admin;

import com.tuprime.common.business.generic.GenericService;
import com.tuprime.entities.Admin;

public interface AdminService extends GenericService<Admin>{
	public Admin loadAdmin(String username);
}
