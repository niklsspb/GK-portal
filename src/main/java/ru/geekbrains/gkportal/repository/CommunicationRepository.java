package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entities.Communication;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, Integer> {

}
