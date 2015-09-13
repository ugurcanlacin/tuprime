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

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@NamedQueries({
	@NamedQuery(name = "getAllExercises", query = "from Exercise e")
	})
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
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "exercise_type", joinColumns = {
			@JoinColumn(name = "exercise_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "type_id", referencedColumnName = "id") })
	private Set<Type> type;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "exercise_muscle", joinColumns = {
			@JoinColumn(name = "exercise_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "muscle_id", referencedColumnName = "id") })
	private Set<Muscle> muscle;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "exercise_level", joinColumns = {
			@JoinColumn(name = "exercise_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "level_id", referencedColumnName = "id") })
	private Set<Level> level;

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
	
	public Set<Type> getType() {
		return type;
	}

	public void setType(Set<Type> type) {
		this.type = type;
	}
	

	public Set<Muscle> getMuscle() {
		return muscle;
	}

	public void setMuscle(Set<Muscle> muscle) {
		this.muscle = muscle;
	}
	
	public Set<Level> getLevel() {
		return level;
	}

	public void setLevel(Set<Level> level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return getExercise();
	}
}
