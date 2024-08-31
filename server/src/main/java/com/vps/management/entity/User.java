package com.vps.management.entity;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Component
@Entity
@Data
public class User {

	@Id
	private String schoolId;

	@Column(nullable=false)
	private String name,email,password,role;



}
