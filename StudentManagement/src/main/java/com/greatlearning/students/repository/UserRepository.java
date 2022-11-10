package com.greatlearning.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.students.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
//	@Query("Select u from user u where u.username=?1")
//	User getUserByUsername(String username);
	
	
	User findByUsername(String username);
}
