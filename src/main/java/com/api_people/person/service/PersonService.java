package com.api_people.person.service;

import com.api_people.person.dto.PersonDto;
import com.api_people.person.entity.Person;
import com.api_people.person.repository.PersonRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonService {

    
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public UUID save(PersonDto personDto){

        var entity = new Person(null,personDto.name(),personDto.birthDate());

       var personSaved = personRepository.save(entity);


       return personSaved.getId();


    }
}
