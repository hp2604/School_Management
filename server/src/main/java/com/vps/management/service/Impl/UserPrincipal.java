package com.vps.management.service.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vps.management.dto.UserDto;



public class UserPrincipal implements UserDetails {

	private UserDto dto;

	public UserPrincipal(UserDto dto)
	{
		this.dto=dto;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
	
		return Collections.singleton(new SimpleGrantedAuthority("admin"));
	}

	@Override
	public String getPassword() {
		return dto.getPassword();
	}

	@Override
	public String getUsername() {

		return dto.getSchoolId();
	}



}
