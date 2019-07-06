package com.example.homework.controller;

import com.example.homework.domain.Address;
import com.example.homework.exception.AddressNotFoundException;
import com.example.homework.service.AddressService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Profile("ShortAddress")
@RestController
@RequestMapping("/Addresses")
public class IdAddressController extends BaseAddressController{

    public IdAddressController(AddressService addressService) {
        super(addressService);
    }

    @RequestMapping(value ="/getAddress", method = RequestMethod.POST)
    public String find(@RequestBody Address address)  throws AddressNotFoundException {
        Address rtnAddress = addressService.find(address);
        if(rtnAddress==null)
            throw new AddressNotFoundException("The address: " + address.toString() + " not found.");
        return "Address ID: " + rtnAddress.getId().toString();
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public void handleAddressNotFound(AddressNotFoundException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(),exception.getMessage());
    }
}