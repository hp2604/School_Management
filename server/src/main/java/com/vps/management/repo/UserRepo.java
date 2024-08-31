package com.vps.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.vps.management.entity.User;

@Component
public interface UserRepo extends JpaRepository<User,String> {
	public User findBySchoolId(String schoolId);


}
