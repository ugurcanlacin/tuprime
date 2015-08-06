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
import com.tuprime.common.business.user.UserService;
import com.tuprime.entities.Admin;
import com.tuprime.entities.Login;
import com.tuprime.entities.Role;
import com.tuprime.entities.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserService userService;
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
			System.out.println("User yok haci");
		}

		return user;
	}

	public User getLoadedObjectForLogin(String username) {
		return userService.loadUser(username);
	}

	private void loadUser(String username) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		User loadedUser = getLoadedObjectForLogin(username);
		if (loadedUser != null) {
			String password = loadedUser.getPasswordHash();
			enabled = loadedUser.isActive();
			List<Role> roles = loadedUser.getRole();
			for (Object role : roles) {
				authorities.add(new GrantedAuthorityImpl(((Role) role)
						.getRole()));
			}
			users.put(username,
					new org.springframework.security.core.userdetails.User(
							username, password, enabled, accountNonExpired,
							credentialsNonExpired, accountNonLocked,
							authorities));
			loadedUser.getLogin().add(new Login(new Date()));
			userService.merge(loadedUser);
		}

	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}


}
