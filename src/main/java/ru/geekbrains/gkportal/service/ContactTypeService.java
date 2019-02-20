package ru.geekbrains.gkportal.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.ContactType;
import ru.geekbrains.gkportal.repository.ContactTypeRepository;

import java.util.List;

@Service
public class ContactTypeService {

    private static final Logger logger = Logger.getLogger(ContactTypeService.class);

    private ContactTypeRepository contactTypeRepository;

    public static final String OWNER_TYPE = "Собственник";

    @Autowired
    public void setContactTypeRepository(ContactTypeRepository contactTypeRepository) {
        this.contactTypeRepository = contactTypeRepository;
    }

    public List<ContactType> getAllContactTypes() {
        List<ContactType> contactTypeList = contactTypeRepository.findAll();
        return contactTypeList;
    }

    public ContactType getContactTypeByDescription(String description) {
        return contactTypeRepository.findByDescription(description);
    }
}
