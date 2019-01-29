package ru.geekbrains.gkportal.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "contact")
@EqualsAndHashCode(callSuper = true)
public class Contact extends AbstractEntity {

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

    public Contact() {
    }
}
