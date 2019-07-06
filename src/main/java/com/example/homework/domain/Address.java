package com.example.homework.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer zipCode;

    private Address() {}

    public boolean equalsfields(Address address){
        boolean city, street, houseNumber;
        city = this.city.equals(address.getCity());
        street = this.street.equals(address.getStreet());
        houseNumber = this.houseNumber.equals(address.getHouseNumber());
        if(city && street && houseNumber) return true;
        return false;

    }
}
