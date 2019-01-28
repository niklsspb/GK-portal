package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    private UUID uuid;

    @Column(name = "description")
    @NotNull(message = "Couldn't be empty!")
    private String description;

    public Role() {
    }

}
