package xyz.fomichev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import xyz.fomichev.domain.Person;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonRowMapperTest {

    private ResultSet resultSet;
    private PersonRowMapper mapper;

    @Before
    public void setUp() {
        resultSet = mock(ResultSet.class);
        mapper = new PersonRowMapper();
    }

    @Test
    public void testCorrectSettingFields() throws SQLException {
        when(resultSet.getString("ID")).thenReturn("myId");
        when(resultSet.getString("LAST_NAME")).thenReturn("myLastName");
        when(resultSet.getString("FIRST_NAME")).thenReturn("myFirstName");
        when(resultSet.getString("PHONE_NUMBER")).thenReturn("myPhoneNumber");
        when(resultSet.getString("EMAIL")).thenReturn("myEmail");
        Person person = mapper.mapRow(resultSet, 0);
        assertEquals("myId", person.getId());
        assertEquals("myLastName", person.getLastName());
        assertEquals("myFirstName", person.getFirstName());
        assertEquals("myPhoneNumber", person.getPhoneNumber());
        assertEquals("myEmail", person.getEmail());
    }
}