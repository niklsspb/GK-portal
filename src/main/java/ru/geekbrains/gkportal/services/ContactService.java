package ru.geekbrains.gkportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entities.Contact;
import ru.geekbrains.gkportal.entities.SystemAccount;
import ru.geekbrains.gkportal.repository.ContactRepository;

import java.util.Arrays;

@Service
public class ContactService {

    private ContactRepository contactRepository;
    private FlatsService flatsService;
    private CommunicationService communicationService;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Autowired
    public void setFlatsService(FlatsService flatsService) {
        this.flatsService = flatsService;
    }

    @Autowired
    public void setCommunicationService(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    public Contact createContact(SystemAccount systemAccount) throws Throwable {

        Contact contact = Contact.builder()
                .contactType(systemAccount.getContactType())
                .firstName(systemAccount.getFirstName())
                .lastName(systemAccount.getLastName())
                .middleName(systemAccount.getMiddleName())
                .flats(Arrays.asList(flatsService.createFlat(systemAccount)))
                .build();

        contact.setCommunications(communicationService.createCommunication(systemAccount, contact));

        return contact;


    }

}

