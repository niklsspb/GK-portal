package ru.geekbrains.gkportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entities.Contact;
import ru.geekbrains.gkportal.entities.SystemAccount;
import ru.geekbrains.gkportal.repository.ContactRepository;

import java.util.Arrays;
import java.util.List;

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

    public Contact findById(String id) {
        return contactRepository.findById(id).orElse(null);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public void saveAll(List<Contact> contactList) {
        contactRepository.saveAll(contactList);
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
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

