package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "communication")
public class Communication {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "communication_type_id")
    private CommunicationType communicationType;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Column(name = "identify")
    private String identify;

    @Column(name = "description")
    private String description;

    @Column(name = "confirmed")
    private boolean confirmed;

    @Column(name = "confirm_code_date")
    private LocalDateTime confirmCodeDate;

    @Column(name = "confirm_code")
    private String confirmCode;

}
