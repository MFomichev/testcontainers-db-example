package xyz.fomichev.repository;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import xyz.fomichev.domain.Person;
import xyz.fomichev.mapper.PersonRowMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonRepositoryTest {

    private PersonRepository repository;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        repository = new PersonRepositoryImpl(jdbcTemplate);
    }

    @Test
    public void testReturnPerson() {
        Person expectedPerson = new Person("007","Иванов", "Иван", "9095551122", "ivan@ivanov.net");
        when(jdbcTemplate.queryForObject(any(), isA(PersonRowMapper.class), eq("007"))).thenReturn(expectedPerson);
        Optional<Person> optional = repository.getPerson("007");
        assertTrue(optional.isPresent());
        assertEquals(expectedPerson, optional.get());
    }

    @Test
    public void testNoSuchPerson() {
        when(jdbcTemplate.queryForObject(any(), isA(PersonRowMapper.class), eq("007")))
                .thenThrow(new EmptyResultDataAccessException(1));
        Optional<Person> optional = repository.getPerson("007");
        assertFalse(optional.isPresent());
    }

}