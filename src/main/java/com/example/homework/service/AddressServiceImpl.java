package com.example.homework.service;

import com.example.homework.domain.Address;
import com.example.homework.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Iterable<Address> list(){
        return addressRepository.findAll();
    }

    @Override
    public Iterable<Address> save(List<Address> addresses){
        return addressRepository.saveAll(addresses);
    }


    @Override
    public Address find(Address input) {
        Address rtnAddress=null;
        Iterable<Address> list = list();
        for(Address address: list){
            if(address.equalsfields(input))
                rtnAddress = address;
        }

        return rtnAddress;
    }

}
