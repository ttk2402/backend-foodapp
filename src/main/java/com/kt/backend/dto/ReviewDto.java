package com.kt.backend.dto;

import com.kt.backend.entity.Account;
import com.kt.backend.entity.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReviewDto {

	private Integer id;
	
	private Integer numberofstar;
	
	private String content;
	
	private String datereview;
	
	private Account account;
	
	private Product product;
}
