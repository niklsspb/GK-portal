package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "properties")
@Data
public class Property {

    @Id
    @Column(name = "property_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column (name ="type")
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    public Property() {
    }
}
