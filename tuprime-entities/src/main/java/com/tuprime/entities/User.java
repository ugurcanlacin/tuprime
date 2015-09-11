package com.tuprime.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
		@NamedQuery(name = "getUser", query = "from User u where u.username =:username and u.passwordHash = :password"),

		@NamedQuery(name = "getUserId", query = "select u.id from User u where u.username =:username"),
		@NamedQuery(name = "getAllUsers", query = "from User u where u.state='1'"),
		@NamedQuery(name = "loadUser", query = "from User u where u.username =:username"),
		@NamedQuery(name = "changeState",query="UPDATE User u SET u.state='0' WHERE u.id=:id")
		})
@Entity
@Table(name = "user", catalog = "sportclubsystem", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
	private List<Role> role;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_login", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "login_id", referencedColumnName = "id") })
	private Set<Login> login;

	@OneToMany(mappedBy = "user")
	//private Set<UserDiet> userDiet = new HashSet<UserDiet>();
	private Set<UserDiet> userDiet;
	
	@OneToMany(mappedBy = "user")
	private Set<UserWorkout> userWorkout = new HashSet<UserWorkout>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_pdetails", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "pdetails_id", referencedColumnName = "id") })
	private Set<PersonalDetails> personalDetails;
	private String username;
	private String passwordHash;
	private String name;
	private String surname;
	private String email;
	private boolean active;
	private Date creationTimestamp;
	private String activationHash;
	private int state;

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
		this.passwordHash = passwordHash;
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

	public User() {
	}

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "state",length=45)
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Set<Login> getLogin() {
		return login;
	}

	public void setLogin(Set<Login> login) {
		this.login = login;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public Set<UserDiet> getUserDiet() {
		return userDiet;
	}

	public void setUserDiet(Set<UserDiet> userDiet) {
		this.userDiet = userDiet;
	}

	public Set<UserWorkout> getUserWorkout() {
		return userWorkout;
	}

	public void setUserWorkout(Set<UserWorkout> userWorkout) {
		this.userWorkout = userWorkout;
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
