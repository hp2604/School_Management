package com.vps.management.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vps.management.dto.UserDto;


@Service
public class UserDetailServices implements UserDetailsService  {

	@Autowired
	private UserServiceImpl user;

	private UserDto dto=null;


	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException  {
	 dto=user.getUser(username);
	 if(dto==null)
	 {
		 throw new UsernameNotFoundException("User not found");
	 }
	return org.springframework.security.core.userdetails.User.builder()
			.username(dto.getSchoolId())
			.password(dto.getPassword())
			.roles(dto.getRole())
			.build();
	}

}
