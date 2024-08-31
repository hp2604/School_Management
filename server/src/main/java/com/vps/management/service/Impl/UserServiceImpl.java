package com.vps.management.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.vps.management.dto.UserDto;
import com.vps.management.entity.User;
import com.vps.management.repo.UserRepo;
import com.vps.management.service.UserService;


@Component
public class UserServiceImpl implements UserService{


	private User user;

	@Autowired
	private UserRepo repo;


	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

	@Override
	public UserDto createUser(UserDto dto) {

		this.user =dtoToUser(dto);
		String pass=encoder.encode(user.getPassword());
		user.setPassword(pass);
		User savedUser=	repo.save(user);
		UserDto userdto=userToDto(savedUser);
		System.out.print("saved User is " + userdto);
		return userdto;
	}

	@Override
	public UserDto getUser(String id) {
		this.user=repo.findBySchoolId(id);
	UserDto dto=userToDto(user);
		return dto;
	}

	@Override
	public UserDto updateuser(UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDto userToDto(User user)
	{
		UserDto userdto=new UserDto();
		userdto.setName(user.getName());
		userdto.setEmail(user.getEmail());
		userdto.setPassword(user.getPassword());
		userdto.setRole(user.getRole());
		userdto.setSchoolId(user.getSchoolId());

		return userdto;
	}

	public User dtoToUser(UserDto userdto)
	{
		User user=new User();
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setRole(userdto.getRole());
		user.setSchoolId(userdto.getSchoolId());

		return user;
	}






}
