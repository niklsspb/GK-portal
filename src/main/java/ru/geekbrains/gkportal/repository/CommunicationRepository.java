package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entities.Communication;
import ru.geekbrains.gkportal.entities.CommunicationType;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, String> {
    Communication findCommunicationByCommunicationTypeAndIdentify(CommunicationType communicationType, String identify);

}
