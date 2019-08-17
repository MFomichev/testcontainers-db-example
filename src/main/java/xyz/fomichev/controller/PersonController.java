package xyz.fomichev.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import xyz.fomichev.domain.ExceptionSerialize;
import xyz.fomichev.domain.Person;
import xyz.fomichev.exception.NoSuchPersonException;
import xyz.fomichev.service.PersonService;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable long id) {
        return personService.getPerson(id);
    }

    @ExceptionHandler(NoSuchPersonException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionSerialize notFound(NoSuchPersonException exception) {
        return new ExceptionSerialize(exception.getMessage());
    }
}
