package com.ugurcanlacin.sportclubsystem.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ugurcanlacin.sportclubsystem.model.Diet;
import com.ugurcanlacin.sportclubsystem.service.DietService;

@ManagedBean
@SessionScoped
public class AddDiet implements Serializable{
	
	private DietService dietService;
	
	private Date timestamp = new Date();
	private String diet;
	
	public void addDiet(){
		Diet dietObj = new Diet();
		dietObj.setDiet(diet);
		dietService.persistDiet(dietObj);
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
	
	
}
