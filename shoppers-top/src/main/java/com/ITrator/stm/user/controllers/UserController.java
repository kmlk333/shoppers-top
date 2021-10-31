package com.ITrator.stm.user.controllers;

import java.util.List;
import java.util.Optional;

import com.ITrator.stm.request.GlobalResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITrator.stm.dto.UserDTO;
import com.ITrator.stm.request.GlobalRequest;
import com.ITrator.stm.user.entity.User;
import com.ITrator.stm.user.services.UserService;
import com.ITrator.stm.util.Utils;

@RestController
@RequestMapping("WebUser/v1")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private GlobalResponse globalResponse;

	@GetMapping("/GetUsers")
	public List<User> getUsers() throws Exception {
		System.out.println("in side get users");
		List<User> users = userService.getUsers();
		System.out.println("exist from get users");
		return users;
	}

	@GetMapping("/GetLimitedUsers")
	public Page<User> getLimitedUsers(Pageable pageable) throws Exception {
		System.out.println("in side get users");
		Page<User> users = userService.getUserPage(pageable);
		System.out.println("exist from get users");
		return users;
	}


	@GetMapping("/GetUsersByPage/{pageno}")
	public List<User> getUsersByPage(@PathVariable("pageno") int pageno){
		//PageRequest pageReqeust = new
		return userService.getUserPageByPageNo(PageRequest.of(pageno,5));
	}

	@GetMapping("/GetUsers/{id}")
	public User getUser(@PathVariable long id) {
		Optional<User> user = userService.getUser(id);
		return user.get();
	}

	@GetMapping("/GetUsers/{userName}/{isDeleted}")
	public User getDeletedUser(@PathVariable String userName, @PathVariable String isDeleted) {
		System.out.println("Inside getDeletedUser");
		return userService.getDeletedUser(userName, Integer.parseInt(isDeleted));
	}

	@PostMapping("/CreateUser")
	public GlobalResponse createUser(@RequestBody String requestJson) {

		GlobalRequest globalRequest = Utils.jsonObjectMapper(requestJson);
		System.out.println(globalRequest);
		UserDTO userDTO = globalRequest.getGlobal().getUserData();

		User user = userService.createUser(userDTO);
		globalResponse.setMessage("User is created successfully");
		globalResponse.setStatusCode(HttpStatus.CREATED);
		System.out.println(user);
		return globalResponse;
	}

	@PutMapping("/UpdateUser/{id}")
	public User updateUser(@RequestBody String requestJson) {

		GlobalRequest globalRequest = Utils.jsonObjectMapper(requestJson);
		System.out.println(globalRequest);
		UserDTO userDTO = globalRequest.getGlobal().getUserData();
		return userService.updateUser(userDTO);
	}

	@DeleteMapping("/DeleteUser/{id}")
	public boolean deleteUser(@PathVariable long id) {
		return userService.deleteUser(id);
	}

	@GetMapping("/FindUser/{id}")
	public User findUser(@PathVariable long id) {
		return userService.findUser(id);
	}

	@PutMapping("/LockUser/{id}")
	public User lockUser(@PathVariable long id) {
		return userService.lockUser(id);
	}

	@PutMapping("/UnlockUser/{id}")
	public User unLockUser(@PathVariable long id) {
		return userService.unlockUser(id);
	}
}
