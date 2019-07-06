package com.example.homework.repository;

import com.example.homework.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
}
