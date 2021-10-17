package com.ITrator.stm.util;

import com.ITrator.stm.dto.UserDTO;
import com.ITrator.stm.request.GlobalRequest;
import com.ITrator.stm.user.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface Utils {
	
	static GlobalRequest jsonObjectMapper(String jsonString) {
		System.out.println(jsonString);
		GlobalRequest globlaRequest = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			globlaRequest = mapper.readValue(jsonString, GlobalRequest.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return globlaRequest;
		}
		System.out.println("Global Request is " + globlaRequest);
		return globlaRequest;
	}
	
	static User convertUserDTO_TO_User(UserDTO userDTO){
		User user = new User();
		user.setUserId(userDTO.getUserId());
		user.setUserName(userDTO.getUserName());
		user.setSessionToken(userDTO.getSessionToken());
		user.setUserDOB(userDTO.getUserDOB());
		user.setUserLocked(userDTO.isUserLocked());
		user.setUserDeleted(userDTO.isUserDeleted());
		user.setUpdatedBy(userDTO.getUpdatedBy());
		user.setUpdatedDate(userDTO.getUpdatedDate());
		return user;
	}
}
