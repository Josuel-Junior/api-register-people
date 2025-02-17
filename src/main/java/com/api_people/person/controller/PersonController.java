package com.api_people.person.controller;

import com.api_people.person.dto.PersonDto;
import com.api_people.person.entity.Person;
import com.api_people.person.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {


    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    public ResponseEntity<Person> createdPerson(@RequestBody PersonDto personDto) {


        var response = personService.save(personDto);


        return ResponseEntity.created(URI.create("./person/" + response.toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<Person>> getList() {

        var listPerson = personService.list();

        return ResponseEntity.ok(listPerson);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonId(@PathVariable("personId") String id) {

        var personOptional = personService.getPersonId(id);

        if (personOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personOptional.get());
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<UUID> delete(@PathVariable("personId") String personId) {

        personService.delete(personId);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{personId}")
    public ResponseEntity<Person> update(@PathVariable("personId") String personId, @RequestBody PersonDto personDto) {

        personService.updated(personId, personDto);

        return ResponseEntity.noContent().build();
    }

}