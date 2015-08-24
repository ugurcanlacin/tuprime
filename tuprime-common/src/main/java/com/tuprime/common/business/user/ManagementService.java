package com.tuprime.common.business.user;

import java.util.List;

import com.tuprime.entities.User;

public interface ManagementService {
	User prepareNewUser(User user);
	User prepareUserForEdit(User user);
	List<String> getUserRoleList(User user);
}
