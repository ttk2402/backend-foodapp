package com.kt.backend.dto;

import com.kt.backend.entity.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductDto {

	private Integer id;
	private String name;
	private Double price;
	private String description;
	private String url_image_product;
	private Category category;
}
