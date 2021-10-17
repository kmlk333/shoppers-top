package com.ITrator.stm.user.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITrator.stm.dto.UserDTO;
import com.ITrator.stm.user.entity.User;
import com.ITrator.stm.user.repositories.UserRepository;
import com.ITrator.stm.user.services.UserService;
import com.ITrator.stm.util.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public Optional<User> getUser(long id) {
		return userRepository.findById(id);
	}
	
	@Override
	public User getDeletedUser(String userName, int isDeleted) {
		return userRepository.getDeletedUser(userName, isDeleted);
	}

	@Override
	public List<User> getUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}
	
	@Override
	public User createUser(UserDTO userDTO) {
		User user = Utils.convertUserDTO_TO_User(userDTO);
		return userRepository.save(user);
	}

	@Override
	public User updateUser(UserDTO userDTO) {
		User user = Utils.convertUserDTO_TO_User(userDTO);
		return userRepository.save(user);
	}

	@Override
	public boolean deleteUser(long id) {
		 userRepository.deleteById(id);
		 return true;
	}

	@Override
	public User findUser(long id) {
		Optional<User> findUser = userRepository.findById(id);
		return findUser.get();
	}

	@Override
	public User lockUser(long id) {
		Optional<User> user = userRepository.findById(id);
		return userRepository.save(user.get());
	}

	@Override
	public User unlockUser(long id) {
		Optional<User> user = userRepository.findById(id);
		return userRepository.save(user.get());
	}

	

}
