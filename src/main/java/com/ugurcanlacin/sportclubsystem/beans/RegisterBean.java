package com.ugurcanlacin.sportclubsystem.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.ugurcanlacin.sportclubsystem.model.Role;
import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.service.RoleService;
import com.ugurcanlacin.sportclubsystem.service.UserService;
import com.ugurcanlacin.sportclubsystem.util.Tool;

@ManagedBean
@SessionScoped
public class RegisterBean implements Serializable{
	
	private String username;
	private String passwordHash;
	private String name;
	private String surname;
	private String email;
	private boolean active;
	private Date creationTimestamp = new Date();
	private String activationHash;
	
	
	private UserService userService;
	private RoleService roleService;
	
	public void mergeUser(){
		User user = new User(username, passwordHash, name, email, active, creationTimestamp);
		user.setActivationHash(Tool.encrypt(email));
		user = setRole(user);
		userService.mergeUser(user);
	}
	public User setRole(User user){
		List<Role> roleList = new ArrayList();
		roleList.add(roleService.getRoleById(3));
		user.setRole(roleList);
		return user;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = Tool.encrypt(passwordHash);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getCreationTimestamp() {
		return creationTimestamp;
	}
	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	public String getActivationHash() {
		return activationHash;
	}
	public void setActivationHash(String activationHash) {
		this.activationHash = activationHash;
	}
	
}
