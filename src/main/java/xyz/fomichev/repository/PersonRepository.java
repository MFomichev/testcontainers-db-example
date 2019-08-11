package xyz.fomichev.repository;

import java.util.Optional;

import xyz.fomichev.domain.Person;

public interface PersonRepository {
    Optional<Person> getPerson(String id);
}
