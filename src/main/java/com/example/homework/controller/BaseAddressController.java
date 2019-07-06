package com.example.homework.controller;

import com.example.homework.domain.Address;
import com.example.homework.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
public class BaseAddressController {

    protected final AddressService addressService;

    @GetMapping("/getAll")
    public Iterable<Address> list(){
        return addressService.list();
    }

}
