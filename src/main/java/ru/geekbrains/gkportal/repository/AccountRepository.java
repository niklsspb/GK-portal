package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findOneByLogin(String login);
}
