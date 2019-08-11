package xyz.fomichev.repository;

import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xyz.fomichev.domain.Person;
import xyz.fomichev.mapper.PersonRowMapper;

@Repository
@AllArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Person> getPerson(String id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(
                    "SELECT * FROM PERSON WHERE ID=?",
                    new PersonRowMapper(),
                    id
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }
}
