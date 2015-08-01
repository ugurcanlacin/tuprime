package com.tuprime.entities;


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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/*
@NamedQueries({
	@NamedQuery(name = "getRoleById",
			query = "from Role r left join r.user its where its.id = :userid" )
})
*/
@NamedQueries({
	@NamedQuery(name ="getAllRoles" , query="from Role"),
	@NamedQuery(name = "getRoleByName" , query = "from Role r where r.role =:role")
	
})
@Entity
@Table(name = "role", catalog = "sportclubsystem")
public class Role implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	private String role;

	
	
	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}



	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "role", nullable = false, length = 32)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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
		Role guest = (Role) other;
		return (this.id == guest.getId());
	}
}
