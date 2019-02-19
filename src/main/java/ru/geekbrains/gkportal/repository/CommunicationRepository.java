package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.Communication;
import ru.geekbrains.gkportal.entity.CommunicationType;
import ru.geekbrains.gkportal.entity.Contact;

import java.util.List;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, String> {

    Communication findCommunicationByCommunicationTypeAndIdentifyAndContact
            (
                    CommunicationType communicationType,
                    String identify,
                    Contact contact
            );

    List<Communication> findAllByCommunicationTypeAndIdentify
            (
                    CommunicationType communicationType,
                    String identify
            );
}
