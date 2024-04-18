package com.kt.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BillDto {

	private Integer id;
	
	private String issuedate;
	
	private Double totalprice;
}
