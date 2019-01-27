package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "contact")
public class Contact {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "contact_type_id")
    @NotNull(message = "Contact type s.b. selected!")
    private ContactType contactType;

    @Column(name = "first_name")
    @NotNull(message = "Couldn't be empty!")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    @NotNull(message = "Couldn't be empty!")
    private String lastName;

}
