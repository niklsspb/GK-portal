package ru.geekbrains.gkportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entities.Communication;
import ru.geekbrains.gkportal.entities.Contact;
import ru.geekbrains.gkportal.entities.SystemAccount;
import ru.geekbrains.gkportal.repository.CommunicationRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CommunicationService {

    private CommunicationRepository communicationRepository;
    private CommunicationTypeService communicationTypeService;

    @Autowired
    public void setCommunicationRepository(CommunicationRepository communicationRepository) {
        this.communicationRepository = communicationRepository;
    }

    @Autowired
    public void setCommunicationTypeService(CommunicationTypeService communicationTypeService) {
        this.communicationTypeService = communicationTypeService;
    }

    public List<Communication> createCommunication(SystemAccount systemAccount, Contact contact) throws Throwable {

        Communication phoneCommunication = Communication.builder()
                .communicationType(communicationTypeService.findPhoneType())
                .identify(systemAccount.getPhoneNumber())
                .confirmCode(UUID.randomUUID().toString())
                .confirmCodeDate(LocalDateTime.now())
                .confirmed(false)
                .description("Кастыльььь")
                .contact(contact)
                .build();

        Communication emailCommunication = Communication.builder()
                .communicationType(communicationTypeService.findEmailType())
                .identify(systemAccount.getEmail())
                .confirmCode(UUID.randomUUID().toString())
                .confirmCodeDate(LocalDateTime.now())
                .confirmed(false)
                .description("Кастыльььь")
                .contact(contact)
                .build();

        return Arrays.asList(phoneCommunication, emailCommunication);
    }

}
