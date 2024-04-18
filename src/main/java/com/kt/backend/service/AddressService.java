package com.kt.backend.service;

import com.kt.backend.dto.AddressDto;

public interface AddressService {

	AddressDto createAddress(AddressDto addressDto);

	AddressDto getAddress(Integer addressId);

	void deleteAddress(Integer addressId);
}
