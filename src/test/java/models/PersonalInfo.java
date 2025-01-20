package models;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PersonalInfo {
    private String first_name;
    private String last_name;
    private String new_password;
}