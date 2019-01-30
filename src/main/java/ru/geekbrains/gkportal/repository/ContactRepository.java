package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

}
