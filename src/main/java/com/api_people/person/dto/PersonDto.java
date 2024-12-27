package com.api_people.person.dto;

import com.api_people.person.entity.Address;

public record PersonDto(Long id, String name, String birthDate, Address address) {
}
