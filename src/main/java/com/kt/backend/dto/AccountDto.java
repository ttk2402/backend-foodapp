package com.kt.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AccountDto {

	private Integer id;
	
	private String phonenumber;
	
	private String firstname;
	
	private String lastname;
	
	private String password;
	
	private String email;
	
}
