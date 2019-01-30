package ru.geekbrains.gkportal.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "account")
public class Account extends AbstractEntity {

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

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @NotNull(message = "Role s.b. selected!")
    private Collection<Role> roles;

    public Account() {
    }
}
