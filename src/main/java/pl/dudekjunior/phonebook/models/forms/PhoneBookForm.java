package pl.dudekjunior.phonebook.models.forms;

import lombok.Data;

@Data
public class PhoneBookForm {
    private String name;
    private String surname;
    private int number;
}
