package com.ITrator.stm.dto;

import java.util.Date;

public class UserDTO {

	private long userId;
	
	private String userName;
	
	private String sessionToken;
	
	private Date userDOB;
	
	
	private boolean isUserLocked;
	
	private boolean isUserDeleted;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	
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


	public UserDTO() {
		
	}

	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", sessionToken=" + sessionToken + ", userDOB="
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
