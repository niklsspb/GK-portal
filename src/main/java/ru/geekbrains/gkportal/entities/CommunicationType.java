package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "communication_type")
public class CommunicationType {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

}
