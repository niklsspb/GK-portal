package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "confirmed")
    private boolean confirmed;

    @Column(name = "active")
    private boolean active;

    @Column(name = "password_hash")
    private String passwordHash;

//    contact_id int(11)

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

}
