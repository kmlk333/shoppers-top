package com.ITrator.stm.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	//@Column(name = "userName")
	private String userName;
	
	//@Column(name = "sessionToken")
	private String sessionToken;
	
	//@Column(name = "userDOB")
	private Date userDOB;
	
	private boolean isUserLocked;
	
	private boolean isUserDeleted;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	
	public User() {
		
	}

	
	public boolean isUserLocked() {
		return isUserLocked;
	}


	public void setUserLocked(boolean isUserLocked) {
		this.isUserLocked = isUserLocked;
	}


	public boolean isUserDeleted() {
		return isUserDeleted;
	}


	public void setUserDeleted(boolean isUserDeleted) {
		this.isUserDeleted = isUserDeleted;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", sessionToken=" + sessionToken + ", userDOB="
				+ userDOB + ", isUserLocked=" + isUserLocked + ", isUserDeleted=" + isUserDeleted + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSessionToken() {
		return sessionToken;
	}
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	public Date getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}
}
