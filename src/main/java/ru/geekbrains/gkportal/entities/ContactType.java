package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "contact_type")
public class ContactType {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    @NotNull(message = "Couldn't be empty!")
    private String description;

}
