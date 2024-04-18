package com.kt.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt.backend.dto.AddressDto;
import com.kt.backend.response.ApiResponse;
import com.kt.backend.service.AddressService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/add")
	public ResponseEntity<AddressDto> addNewAddress(@RequestBody AddressDto addressDto) {
		AddressDto createdAddress = this.addressService.createAddress(addressDto);
		return new ResponseEntity<AddressDto>(createdAddress, HttpStatus.CREATED);
	}
	
	@GetMapping("/{addressId}")
	public ResponseEntity<AddressDto> getAddressById(@PathVariable Integer addressId) {
		AddressDto addressDto = this.addressService.getAddress(addressId);
		return new ResponseEntity<AddressDto>(addressDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{addressId}")
	public ResponseEntity<ApiResponse> deleteAddressById(@PathVariable Integer addressId) {
		this.addressService.deleteAddress(addressId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Address is deleted successfully!", true),
				HttpStatus.OK);
	}	
}
