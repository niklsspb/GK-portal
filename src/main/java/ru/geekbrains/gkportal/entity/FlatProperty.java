package ru.geekbrains.gkportal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "flat_property")
public class FlatProperty extends AbstractEntity {
    @Column
    private String description;
    @Column(name = "css_style_name")
    private String styleNameCSS;
    @Column
    private Integer position;
    //@Column(name = "d")


}
