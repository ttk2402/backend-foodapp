package com.kt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.backend.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
