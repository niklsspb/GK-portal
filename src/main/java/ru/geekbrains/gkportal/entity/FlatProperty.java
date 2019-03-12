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
    @Column(name = "date1_enabled")
    private Boolean enabledDate1;
    @Column(name = "date2_enabled")
    private Boolean enabledDate2;
    @Column(name = "comment_enabled")
    private Boolean enablesComment;
    @Column(name = "date1_description")
    private String descriptionDate1;
    @Column(name = "date2_description")
    private String descriptionDate2;
    @Column
    // пока всегда отбираем только = 1
    private Integer type;


}
