package com.vps.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vps.management.dto.UserDto;
import com.vps.management.service.Impl.UserServiceImpl;
import com.vps.management.utils.jwt.JwtService;



@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:3000")
public class AuthController {

	@Autowired
	private UserServiceImpl user;
	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private JwtService jwt;





	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto dto)
	{
	
			Authentication auth=manager.authenticate(new UsernamePasswordAuthenticationToken(dto.getSchoolId(),dto.getPassword()));
			if(auth.isAuthenticated())
			{
				final String token=jwt.generateToken(dto.getSchoolId());
			
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(token);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Password or Email");
			}
		
		
		
		
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody UserDto dto)
	{
		try
		{
			UserDto userdto=user.createUser(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(" Account Created Successfull ");
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
		}
	}



}
