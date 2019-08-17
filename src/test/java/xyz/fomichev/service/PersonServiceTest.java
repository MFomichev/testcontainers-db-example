package xyz.fomichev.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import xyz.fomichev.domain.Person;
import xyz.fomichev.exception.NoSuchPersonException;
import xyz.fomichev.repository.PersonRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonServiceTest {

    private PersonService service;
    private PersonRepository repository;

    @Before
    public void setUp() {
        repository = mock(PersonRepository.class);
        service = new PersonServiceImpl(repository);
    }

    @Test
    public void testServiceReturnPerson() {
        Person expectedPerson = new Person(7,"Иванов", "Иван", "9095551122", "ivan@ivanov.net");
        when(repository.getPerson(7)).thenReturn(Optional.of(expectedPerson));
        assertEquals(expectedPerson, service.getPerson(7));
    }

    @Test(expected = NoSuchPersonException.class)
    public void testIfRepositoryNotReturnPerson() {
        when(repository.getPerson(7)).thenReturn(Optional.empty());
        service.getPerson(7);
    }

}

