package com.example.homework.controller;

import com.example.homework.domain.Address;
import com.example.homework.exception.AddressNotFoundException;
import com.example.homework.service.AddressService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Profile("FullAddress")
@RestController
@RequestMapping("/Addresses")
public class FullAddressController extends BaseAddressController{


    public FullAddressController(AddressService addressService) {
        super(addressService);
    }

    @RequestMapping(value ="/getAddress", method = RequestMethod.POST)
    public Address find(@RequestBody Address address)  throws AddressNotFoundException {
        Address rtnAddress = addressService.find(address);
        if(rtnAddress==null)
            throw new AddressNotFoundException("The address: " + address.toString() + " not found.");
        return rtnAddress;
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public void handleAddressNotFound(AddressNotFoundException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(),exception.getMessage());
    }
}
