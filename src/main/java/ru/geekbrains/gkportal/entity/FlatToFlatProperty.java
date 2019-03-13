package ru.geekbrains.gkportal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
@Setter
@Getter
public class FlatToFlatProperty extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;
    @OneToOne
    @JoinColumn(name = "flat_property_id")
    private FlatProperty flatProperty;
    @Column(name = "date_change")
    private Date createDate;
    @OneToOne
    @JoinColumn(name = "changed_by_contact_id")
    private Contact changedByContact;
    @Column
    private String comment;
    @Column
    private Date date1;
    @Column
    private Date date2;
}
