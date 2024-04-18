package com.kt.backend.service;

import java.util.List;
import java.util.Optional;

import com.kt.backend.dto.DiscountDto;
import com.kt.backend.entity.Discount;

public interface DiscountService {

	DiscountDto createDiscount(DiscountDto discountDto);
	
	Optional<List<Discount>> getListDiscountCurrent();
	
	Optional<List<Discount>> getListDiscount();
	
	Optional<Discount>  findDiscount(String code);
	
	DiscountDto changeStatusDiscount(Integer discountId);
	
	void deleteDiscount(Integer discountId);
	
	DiscountDto updateDiscount(DiscountDto discountDto, Integer discountId);
}
