package com.tuprime.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exercise", catalog = "sportclubsystem")
public class Exercise implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private String exercise;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "workout_exercise", joinColumns = {
			@JoinColumn(name = "exercise_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "workout_id", referencedColumnName = "id") })
	private Set<Workout> workouts;

	public Exercise() {
	}

	public Exercise(Integer id, String exercise) {
		super();
		this.id = id;
		this.exercise = exercise;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "exercise", length = 45)
	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}


	public Set<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(Set<Workout> workouts) {
		this.workouts = workouts;
	}
	
	@Override
	public String toString() {
		return getExercise();
	}
}
