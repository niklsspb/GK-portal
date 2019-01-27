package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "id")
    private UUID uuid;

    @Column(name = "login")
    @NotNull(message = "Couldn't be empty!")
    private String login;

    @Column(name = "confirmed")
    @NotNull(message = "Couldn't be empty!")
    private boolean confirmed;

    @Column(name = "active")
    @NotNull(message = "Couldn't be empty!")
    private boolean active;

    @Column(name = "password_hash")
    @NotNull(message = "Couldn't be empty!")
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @NotNull(message = "Role s.b. selected!")
    private Collection<Role> roles;

    public Account() {
    }
}
