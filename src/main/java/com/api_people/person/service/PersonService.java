package com.api_people.person.service;

import com.api_people.person.dto.PersonDto;
import com.api_people.person.entity.Person;
import com.api_people.person.repository.PersonRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {


    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public UUID save(PersonDto personDto) {

        var entity = new Person(null, personDto.name(), personDto.birthDate());

        var personSaved = personRepository.save(entity);


        return personSaved.getId();


    }

    public List<Person> list() {

        return personRepository.findAll();

    }

    public Optional<Person> getPersonId(String personId) {
        var idPerson = UUID.fromString(personId);

        return personRepository.findById(idPerson);

    }

    public void delete(String personId) {

        var id = UUID.fromString(personId);

        personRepository.deleteById(id);

    }

    public void updated(String personId, PersonDto personDto) {

        var idPerson = UUID.fromString(personId);

        var personEntity = personRepository.findById(idPerson);

        if (personEntity.isPresent()) {
            var person = personEntity.get();

            if (person.getName() != null) {
                person.setName(personDto.name());
            }

            if (person.getBirthDate() != null) {
                person.setBirthDate(personDto.birthDate());
            }

            personRepository.save(person);
        }


    }
}
