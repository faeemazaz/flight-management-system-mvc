package com.flightbook.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "AUTH_USER_GROUP")
public class AuthGroupEntity {

	@Id
	@Column(name = "AUTH_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "AUTH_GROUP")
	private String authGroup;

	@JsonManagedReference("auth")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "authGroupEntity")
	private Set<UserEntity> userEntities;

	public AuthGroupEntity(Long id, String authGroup, Set<UserEntity> userEntities) {
		super();
		this.id = id;
		this.authGroup = authGroup;
		this.userEntities = userEntities;
	}

	public AuthGroupEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthGroup() {
		return authGroup;
	}

	public void setAuthGroup(String authGroup) {
		this.authGroup = authGroup;
	}

	public Set<UserEntity> getUserEntities() {
		return userEntities;
	}

	public void setUserEntities(Set<UserEntity> userEntities) {
		this.userEntities = userEntities;
	}

}
