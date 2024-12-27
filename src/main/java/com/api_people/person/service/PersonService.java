package com.api_people.person.service;

import com.api_people.person.dto.PersonDto;
import com.api_people.person.entity.Person;
import com.api_people.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public void save(PersonDto date){

        var person = new Person(date);

        personRepository.save(person);

    }
}
