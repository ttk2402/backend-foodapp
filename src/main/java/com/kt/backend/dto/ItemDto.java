package com.kt.backend.dto;

import com.kt.backend.entity.Discount;
import com.kt.backend.entity.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ItemDto {

	private Integer id;
	
	private int quantity;
	
	private Double price;

	private Boolean isReviewed;
	
	private Product product;
	
	private Discount discount;
	
}
