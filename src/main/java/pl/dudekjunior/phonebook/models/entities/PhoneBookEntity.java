package pl.dudekjunior.phonebook.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "phone_book")
@Data
public class PhoneBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private int number;
}
