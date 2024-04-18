package com.kt.backend.dto;

import com.kt.backend.entity.AccountStatus;
import com.kt.backend.entity.Address;
import com.kt.backend.entity.Cart;
import com.kt.backend.entity.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResAccountDto {

	private Integer id;
	
	private String phonenumber;
	
	private String firstname;
	
	private String lastname;
	
	private String password;
	
	private String email;
	
	private Role role;
	
	private Cart cart;
	
	private AccountStatus account_status;
	
	private Address address;
	
}
