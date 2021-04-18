package com.redbird.lesson14.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;

}
