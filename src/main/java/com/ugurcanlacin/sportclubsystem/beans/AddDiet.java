package com.ugurcanlacin.sportclubsystem.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ugurcanlacin.sportclubsystem.model.Diet;
import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.service.DietService;
import com.ugurcanlacin.sportclubsystem.service.UserService;

@ManagedBean
@SessionScoped
public class AddDiet implements Serializable{
	
	private DietService dietService;
	private UserService userService;
	
	private Date timestamp = new Date();
	private String diet;
	private String username;
	
	public void addDiet(){
		User u =  userService.loadUser(username);
		
		Diet dietObj = new Diet();
		dietObj.setDiet(diet);
		dietObj.setTimestamp(timestamp);
		Set<Diet> dietList = u.getDiet();
		if(dietList == null){
			dietList = new HashSet<Diet>();
		}
			dietList.add(dietObj);
		u.setDiet(dietList);
		userService.mergeUser(u);
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	public DietService getDietService() {
		return dietService;
	}
	public void setDietService(DietService dietService) {
		this.dietService = dietService;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
