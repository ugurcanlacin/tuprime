package com.tuprime.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "region", catalog = "sportclubsystem")
public class Region implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	private String region;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name="exercise_region",
	joinColumns={@JoinColumn(name="region_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="exercise_id", referencedColumnName="id")})
	private List<Exercise> exerciseList;

	public Region() {
	}

	public Region(Integer id, String region) {
		super();
		this.id = id;
		this.region = region;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "region", length = 45)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Exercise> getExerciseList() {
		return exerciseList;
	}

	public void setExerciseList(List<Exercise> exerciseList) {
		this.exerciseList = exerciseList;
	}

	@Override
	public String toString() {
		return getRegion();
	}
}
