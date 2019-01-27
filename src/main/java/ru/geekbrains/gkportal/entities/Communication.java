package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "communication")
public class Communication {

    @Id
    @Column(name = "id")
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "communication_type_id")
    @NotNull(message = "Communication type s.b. selected!")
    private CommunicationType communicationType;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    @NotNull(message = "Contact s.b. selected!")
    private Contact contact;

    @Column(name = "identify")
    @NotNull(message = "Couldn't be empty!")
    private String identify;

    @Column(name = "description")
    @NotNull(message = "Couldn't be empty!")
    private String description;

    @Column(name = "confirmed")
    @NotNull(message = "Couldn't be empty!")
    private boolean confirmed;

    @Column(name = "confirm_code_date")
    @NotNull(message = "Couldn't be empty!")
    private LocalDateTime confirmCodeDate;

    @Column(name = "confirm_code")
    private String confirmCode;

    public Communication() {
    }
}
