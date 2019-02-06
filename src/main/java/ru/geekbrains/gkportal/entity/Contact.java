package ru.geekbrains.gkportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.geekbrains.gkportal.entity.questionnaire.QuestionnaireContactConfirm;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Entity(name = "contact")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contact_flat",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "flat_id"))
    private Collection<Flat> flats;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Collection<Communication> communications;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "contact_id")
//    private Collection<RealEstate> realEstates;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    @JsonIgnore
    private Collection<QuestionnaireContactConfirm> questionnaireContactConfirms;

}
