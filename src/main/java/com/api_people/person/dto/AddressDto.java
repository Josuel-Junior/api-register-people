package com.api_people.person.dto;

import com.api_people.person.entity.Address;

public record AddressDto(String street, String city, String zipCode, Integer number) {

}
