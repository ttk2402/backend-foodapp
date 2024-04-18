package com.kt.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UpdateAccountDto {
	
	private String firstname;
	
	private String lastname;
	
	private String phonenumber;
	
	private String email;
	
}
