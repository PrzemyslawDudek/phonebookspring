package pl.dudekjunior.phonebook.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phonebook")
@Data
public class PhoneBookEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String number;
}
