package com.tuprime.common.security;

import com.tuprime.entities.Admin;
import com.tuprime.entities.User;
public interface AuthenticationService{
	public Admin getAuthenticatedAdmin();
	public User getAuthenticatedUserInstance();
}
