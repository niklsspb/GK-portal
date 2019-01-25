package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contact")
public class Contact {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "contact_type_id")
    private ContactType contactType;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

}
