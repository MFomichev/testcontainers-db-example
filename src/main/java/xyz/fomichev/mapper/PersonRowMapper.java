package xyz.fomichev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import xyz.fomichev.domain.Person;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(
                rs.getLong("ID"),
                rs.getString("LAST_NAME"),
                rs.getString("FIRST_NAME"),
                rs.getString("PHONE_NUMBER"),
                rs.getString("EMAIL")
        );
    }
}