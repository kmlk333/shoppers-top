package com.ITrator.stm.user.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ITrator.stm.user.entity.User;

@Repository
public interface UserPagingRepository extends PagingAndSortingRepository<User, Long>{


}
