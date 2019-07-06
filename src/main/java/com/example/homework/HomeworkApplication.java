package com.example.homework;

import com.example.homework.domain.Address;
import com.example.homework.service.AddressService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.util.xml.impl.Input;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AddressService addressService){
        return args -> {
            // read json into db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Address>> typeReference = new TypeReference<List<Address>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/AddressesDB.json");
            try{
                List<Address> addresses = mapper.readValue(inputStream,typeReference);
                addressService.save(addresses);
                System.out.println("Saved");
            }
            catch (IOException e){
                System.out.println("unable to save"+e.getMessage());
            }
        };
    }

}
