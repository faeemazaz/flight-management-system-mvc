package com.flightbook.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USER_TABLE")
public class UserEntity {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME", nullable = false, unique = true)
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@JsonBackReference("auth")
	@ManyToOne(targetEntity = AuthGroupEntity.class)
	@JoinColumn(name = "auth_id")
	private AuthGroupEntity authGroupEntity;

	@JsonManagedReference("booking")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
	private List<BookEntity> bookEntities;

	public UserEntity() {

	}

	public UserEntity(Long id, String userName, String password, AuthGroupEntity authGroupEntity,
			List<BookEntity> bookEntities) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.authGroupEntity = authGroupEntity;
		this.bookEntities = bookEntities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthGroupEntity getAuthGroupEntity() {
		return authGroupEntity;
	}

	public void setAuthGroupEntity(AuthGroupEntity authGroupEntity) {
		this.authGroupEntity = authGroupEntity;
	}

	public List<BookEntity> getBookEntities() {
		return bookEntities;
	}

	public void setBookEntities(List<BookEntity> bookEntities) {
		this.bookEntities = bookEntities;
	}

}
