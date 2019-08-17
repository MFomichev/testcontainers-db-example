package xyz.fomichev.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {
    private long id;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;
}
