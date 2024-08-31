package com.vps.management.utils.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	JwtService jwtservice;
	@Autowired
	ApplicationContext context;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

	String token=null;
	String username=null;
	String authHeader=request.getHeader("Authorization");

	if(authHeader!=null && authHeader.startsWith("Bearer "))
	{

		token=authHeader.substring(7);
		System.out.println(token);
		username=jwtservice.extractUsername(token);
		System.out.print(username);
	}

	if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
	{
		UserDetails userdetail=context.getBean(UserDetailsService.class).loadUserByUsername(username);
		System.out.print( userdetail.getPassword() +userdetail.getAuthorities());
		if(jwtservice.validateToken(token,userdetail))
		{
			UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userdetail,null,userdetail.getAuthorities());
			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authToken);
		}

	}
	filterChain.doFilter(request, response);
	}



}
