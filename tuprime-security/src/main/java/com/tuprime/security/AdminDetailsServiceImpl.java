package com.tuprime.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tuprime.common.business.admin.AdminService;
import com.tuprime.common.business.role.RoleService;
import com.tuprime.entities.Admin;
import com.tuprime.entities.Login;
import com.tuprime.entities.Role;
import com.tuprime.entities.User;

@Service("adminDetailsService")
public class AdminDetailsServiceImpl implements UserDetailsService{

	private AdminService adminService;
	private RoleService roleService;

	private HashMap<String, org.springframework.security.core.userdetails.User> users = new HashMap<String, org.springframework.security.core.userdetails.User>();

	boolean enabled = false;
	boolean accountNonExpired = true;
	boolean credentialsNonExpired = true;
	boolean accountNonLocked = true;
	
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		loadUser(username);

		org.springframework.security.core.userdetails.User user = users
				.get(username);

		if (user == null) {
			throw new UsernameNotFoundException("UserAccount for name \""
					+ username + "\" not found.");
		}

		return user;
	}
	
	private Admin getLoadedObjectForLogin(String username){
		return adminService.loadAdmin(username);
	}

	private void loadUser(String username) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Admin loadedAdmin = getLoadedObjectForLogin(username);
		if(loadedAdmin != null){
			String password = loadedAdmin.getPasswordHash();
			enabled = loadedAdmin.isActive();
			List<Role> roles = loadedAdmin.getRole();
			for (Object role : roles) {
				authorities.add(new GrantedAuthorityImpl(((Role) role).getRole()));
			}
			users.put(username,
					new org.springframework.security.core.userdetails.User(
							username, password, enabled, accountNonExpired,
							credentialsNonExpired, accountNonLocked, authorities));
			loadedAdmin.getLogin().add(new Login(new Date()));
			adminService.merge(loadedAdmin);
		}
		
	}


	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
