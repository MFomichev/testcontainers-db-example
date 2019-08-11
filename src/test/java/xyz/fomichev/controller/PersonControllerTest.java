package xyz.fomichev.controller;

import org.junit.Before;
import org.junit.Test;
import xyz.fomichev.domain.Person;
import xyz.fomichev.exception.NoSuchPersonException;
import xyz.fomichev.service.PersonService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonControllerTest {

    private PersonController controller;
    private PersonService personService;

    @Before
    public void setUp() {
        personService = mock(PersonService.class);
        controller = new PersonController(personService);
    }

    @Test
    public void testReturnPerson() {
        Person expectedPerson = new Person("007","Иванов", "Иван", "9095551122", "ivan@ivanov.net");
        when(personService.getPerson("007")).thenReturn(expectedPerson);
        assertEquals(expectedPerson, controller.getPerson("007"));
    }

    @Test
    public void testExceptionHandling() {
        String expected = "Very good message";
        assertEquals(expected, controller.notFound(new NoSuchPersonException(expected)).getMessage());
    }

}