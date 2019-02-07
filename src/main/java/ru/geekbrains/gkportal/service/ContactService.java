package ru.geekbrains.gkportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.dto.AnswerResultDTO;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.SystemAccount;
import ru.geekbrains.gkportal.repository.ContactRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class ContactService {

    private ContactRepository contactRepository;
    private FlatsService flatsService;
    private CommunicationService communicationService;
    private ContactTypeService contactTypeService;

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

    @Autowired
    public void setContactTypeService(ContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
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

    public Contact createContact(AnswerResultDTO answerResultDTO) throws Throwable {

        Contact contact = Contact.builder()
                .contactType(contactTypeService.getContactTypeByDescription("Собственник"))
                .firstName(answerResultDTO.getFullName())
                .lastName("TOSPLIT")
                .build();

        contact.setCommunications(communicationService.createCommunication(answerResultDTO, contact));
        return contact;
    }

}

