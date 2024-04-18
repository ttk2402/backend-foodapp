package com.kt.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DiscountDto {

	private Integer id;
	
	private String code;
	
	private Double percent;
	
	private Boolean isExist;
	
	private String startdate;
	
	private String enddate;
}
