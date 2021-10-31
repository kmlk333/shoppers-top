package com.ITrator.stm.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ITrator.stm.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.userName=?1 and u.isUserDeleted=?2")
	public User getDeletedUser(String userName, int isUserDeleted);
	
	//@Query(name = "select u from user u where u.userName=?1 and u.isUserDeleted=?2", nativeQuery = true)
	//public User getDeletedUserFromDB(String userName, int isUserDeleted);
}
