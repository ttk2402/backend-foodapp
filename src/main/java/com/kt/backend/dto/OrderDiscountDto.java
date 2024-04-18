package com.kt.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderDiscountDto {

	private Integer id;

	private String orderdate;
	
	private String code;
	
}
