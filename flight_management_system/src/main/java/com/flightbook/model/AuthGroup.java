package com.flightbook.model;

public class AuthGroup {
	private Long id;
	private String authGroup;

	public AuthGroup(Long id, String userName, String authGroup) {
		super();
		this.id = id;
		this.authGroup = authGroup;
	}

	public AuthGroup() {
		super();
		// TODO Auto-generated constructor stub
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

}
