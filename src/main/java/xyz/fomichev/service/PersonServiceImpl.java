package xyz.fomichev.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.fomichev.domain.Person;
import xyz.fomichev.exception.NoSuchPersonException;
import xyz.fomichev.repository.PersonRepository;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person getPerson(long id) {
        return personRepository.getPerson(id)
                .orElseThrow(() -> new NoSuchPersonException(format("Person with id %s is not found", id)));
    }
}
