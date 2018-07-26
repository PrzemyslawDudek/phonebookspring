package pl.dudekjunior.phonebook.models.forms;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class PhoneBookForm {
    @Size(max = 30)
    private String name;
    @Size(max = 30)
    private String surname;
    @Size(min = 9, max = 9)
    private String number;
}
