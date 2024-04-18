package com.kt.backend.dto;

import java.util.List;

import com.kt.backend.entity.Account;
import com.kt.backend.entity.Bill;
import com.kt.backend.entity.CheckOut;
import com.kt.backend.entity.Discount;
import com.kt.backend.entity.Item;
import com.kt.backend.entity.OrderStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResOrderDto {


	private Integer id;
	
	private String orderdate;
	
	private Double totalprice;
	
	private Account account;
	
	private Discount discount;
	
	private OrderStatus orderStatus;

	private Bill bill;

	private CheckOut checkout;

	private List<Item> items;
}
