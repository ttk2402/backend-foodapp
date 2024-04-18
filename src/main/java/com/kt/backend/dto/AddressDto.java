package com.kt.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddressDto {

	private Integer id;
	
	private String street;
	
	private String ward;
	
	private String district;
	
	private String province;
	
}
