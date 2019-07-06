package com.example.homework.service;

import com.example.homework.domain.Address;
import com.example.homework.exception.AddressNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface AddressService {
    Iterable<Address> list();
    public Iterable<Address> save(List<Address> addresses);
    public  Address find(Address address);
}
