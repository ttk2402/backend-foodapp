package com.kt.backend.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kt.backend.dto.AddressDto;
import com.kt.backend.entity.Address;
import com.kt.backend.exception.ResourceNotFoundException;
import com.kt.backend.repository.AddressRepository;
import com.kt.backend.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AddressDto createAddress(AddressDto addressDto) {
		Address address = this.modelMapper.map(addressDto, Address.class);
		Address addAddress = this.addressRepository.save(address);
		return this.modelMapper.map(addAddress, AddressDto.class);
	}

	@Override
	public AddressDto getAddress(Integer addressId) {
		Address address = this.addressRepository.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("Address","AddressId", addressId));
		return this.modelMapper.map(address, AddressDto.class);
	}

	@Override
	public void deleteAddress(Integer addressId) {
		Address address = this.addressRepository.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("Address","AddressId", addressId));
		this.addressRepository.delete(address);
		
	}

}
