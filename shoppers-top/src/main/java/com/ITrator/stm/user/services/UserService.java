package com.ITrator.stm.user.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

	Page<User> getLimitedUsers(Optional<Integer> page, Optional<String> sortBy);

	Page<User> getUserPage(Pageable pagable);

	List<User> getUserPageByPageNo(PageRequest pageReqeust);


}
