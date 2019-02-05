package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entities.Account;
import ru.geekbrains.gkportal.entities.Contact;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    Account findOneByLogin(String login);

    Account findByContact(Contact contact);

}
