package com.ITrator.stm.user.services;

import java.util.List;
import java.util.Optional;

import com.ITrator.stm.dto.UserDTO;
import com.ITrator.stm.user.entity.User;

public interface UserService {

	List<User> getUsers();
	
	Optional<User> getUser(long id);

	User getDeletedUser(String userName, int isDeleted);
	
	User createUser(UserDTO userDTO);

	User updateUser(UserDTO userDTO);
	
	boolean deleteUser(long id);

	User findUser(long id);

	User lockUser(long id);

	User unlockUser(long id);


}
