package com.ugurcanlacin.sportclubsystem.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ugurcanlacin.sportclubsystem.model.User;
import com.ugurcanlacin.sportclubsystem.model.Workout;
import com.ugurcanlacin.sportclubsystem.service.UserService;

@ManagedBean
@SessionScoped
public class AddWorkout implements Serializable {

	private UserService userService;

	private Date timestamp = new Date();
	private String workoutProgram;
	private String username;

	public void addWorkoutProgram(){
		User u = userService.loadUser(username);
		Workout w = new Workout();
		w.setTimestamp(timestamp);
		w.setWorkoutProgram(workoutProgram);
		Set<Workout> workoutSet = u.getWorkout();
		if(workoutSet == null){
			workoutSet = new HashSet<Workout>();
		}
		workoutSet.add(w);
		u.setWorkout(workoutSet);
		userService.merge(u);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getWorkoutProgram() {
		return workoutProgram;
	}

	public void setWorkoutProgram(String workoutProgram) {
		this.workoutProgram = workoutProgram;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
