package com.api_people.person.controller;

import com.api_people.person.dto.AddressDto;
import com.api_people.person.entity.Address;
import com.api_people.person.service.AddressService;
import com.api_people.person.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/address")
public class AddressController {

    private AddressService AddressService;

    public AddressController(com.api_people.person.service.AddressService addressService) {
        AddressService = addressService;
    }

    @PostMapping("/{personId}")
    public ResponseEntity<Address> createdAddress(@PathVariable("personId") String personId,@RequestBody AddressDto addressDto){

        System.out.println("Dados recebidos: " + addressDto);

        Address savedAddress = AddressService.saveAddress(personId, addressDto);

        return ResponseEntity.ok(savedAddress);
    }

}
