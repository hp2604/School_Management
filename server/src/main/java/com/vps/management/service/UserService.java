package com.vps.management.service;
import com.vps.management.dto.UserDto;

public interface UserService {

	//create new User
   UserDto createUser(UserDto dto);

   //get User
   UserDto getUser(String id);

   //Update Password
   UserDto updateuser(UserDto dto);



}
