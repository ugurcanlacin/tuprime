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

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({ @NamedQuery(name = "loadAdmin", query = "from Admin a where a.username =:username") })
@Entity
@Table(name = "admin", catalog = "sportclubsystem", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class Admin implements java.io.Serializable {

	private Integer id;
	private String username;
	private String passwordHash;
	private String name;
	private String surname;
	private String email;
	private boolean active;
	private Date creationTimestamp;
	private String activationHash;

	public Admin() {
	}

	public Admin(String username, String passwordHash, String name,
			String email, boolean active, Date creationTimestamp) {
		this.username = username;
		this.passwordHash = passwordHash;
		this.name = name;
		this.email = email;
		this.active = active;
		this.creationTimestamp = creationTimestamp;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
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

	@Temporal(TemporalType.DATE)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_login", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "login_id", referencedColumnName = "id") })
	private Set<Login> login;

	private List<Role> role;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "admin_roles", joinColumns = { @JoinColumn(name = "admin_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "admin_login", joinColumns = { @JoinColumn(name = "admin_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "login_id", referencedColumnName = "id") })
	public Set<Login> getLogin() {
		return login;
	}

	public void setLogin(Set<Login> login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return getName();
	}
}
