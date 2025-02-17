package com.api_people.person.service;


import com.api_people.person.dto.AddressDto;
import com.api_people.person.entity.Address;
import com.api_people.person.entity.Person;
import com.api_people.person.repository.AddressRepository;
import com.api_people.person.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    private PersonRepository personRepository;
    private AddressRepository addressRepository;

    public AddressService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public Address saveAddress(String personId, AddressDto addressDto){




        var idPerson = UUID.fromString(personId);

        Person person = personRepository.findById(idPerson)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa com ID " + personId + " não encontrada"));

        System.out.println("Criando endereço com: " + addressDto);

        var entityAddress = new Address(null,addressDto.street(), addressDto.city(), addressDto.zipCode(), addressDto.number(), person);

        return addressRepository.save(entityAddress);

    }
}
