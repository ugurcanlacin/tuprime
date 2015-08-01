package com.tuprime.entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@NamedQueries({
	@NamedQuery(name = "getUser", query = "from User u where u.username =:username and u.passwordHash = :password"),

	@NamedQuery(name = "getUserId", query = "select u.id from User u where u.username =:username"),
	@NamedQuery(name = "getAllUsers", query = "from User"),
	@NamedQuery(name = "loadUser", query = "from User u where u.username =:username")
})
@Entity
@Table(name = "user", catalog = "sportclubsystem", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	private String username;
	private String passwordHash;
	private String name;
	private String surname;
	private String email;
	private boolean active;
	private Date creationTimestamp = new Date();
	private String activationHash;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_roles",
	joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
	private List<Role> role;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_diet",
	joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="diet_id", referencedColumnName="id")})
	private Set<Diet> diet;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_workout",
	joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="workout_id", referencedColumnName="id")})
	private Set<Workout> workout;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_pdetails",
	joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="pdetails_id", referencedColumnName="id")})
	private Set<PersonalDetails> personalDetails;
	
	public User() {
	}

	public User(String username, String passwordHash, String name,
			String email, boolean active, Date creationTimestamp) {
		this.username = username;
		this.passwordHash = passwordHash;
		this.name = name;
		this.email = email;
		this.active = active;
		this.creationTimestamp = creationTimestamp;
	}

	public User(String username, String passwordHash, String name,
			String surname, String email, boolean active,
			Date creationTimestamp, String activationHash) {
		this.username = username;
		this.passwordHash = passwordHash;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.active = active;
		this.creationTimestamp = creationTimestamp;
		this.activationHash = activationHash;

	}


	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", unique = true, nullable = false, length = 64)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password_hash", nullable = false)
	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash =passwordHash;
	}

	@Column(name = "name", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", length = 64)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "email", unique = true, nullable = false, length = 64)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_timestamp", nullable = false, length = 10)
	public Date getCreationTimestamp() {
		return this.creationTimestamp;
	}

	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	@Column(name = "activation_hash", length = 40)
	public String getActivationHash() {
		return this.activationHash;
	}

	public void setActivationHash(String activationHash) {
		this.activationHash = activationHash;
	}



	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public Set<Diet> getDiet() {
		return diet;
	}

	public void setDiet(Set<Diet> diet) {
		this.diet = diet;
	}

	public Set<Workout> getWorkout() {
		return workout;
	}

	public void setWorkout(Set<Workout> workout) {
		this.workout = workout;
	}

	public Set<PersonalDetails> getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(Set<PersonalDetails> personalDetails) {
		this.personalDetails = personalDetails;
	}

	@Override
	public int hashCode() {
		return getId();
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null || (this.getClass() != other.getClass())) {
			return false;
		}
		User guest = (User) other;
		return (this.id == guest.getId());
	}
}
