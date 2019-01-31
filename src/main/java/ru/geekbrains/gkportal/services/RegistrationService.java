package ru.geekbrains.gkportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entities.*;
import ru.geekbrains.gkportal.repository.AccountRepository;
import ru.geekbrains.gkportal.repository.ContactRepository;
import ru.geekbrains.gkportal.repository.FlatRepository;
import ru.geekbrains.gkportal.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    private FlatRepository flatRepository;
    private AccountRepository accountRepository;
    private BCryptPasswordEncoder encoder;
    private RoleRepository roleRepository;
    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Autowired
    public void setFlatRepository(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean registerNewUser(SystemAccount systemAccount) {
        Optional<Flat> flatOptional = flatRepository.findByHouseAndPorchAndFloorAndFlatNumber(systemAccount.getHousingNumber(),
                systemAccount.getPorchNumber(), systemAccount.getFloorNumber(), systemAccount.getFlatNumber());
        if (flatOptional.isPresent()) {
            Contact contact = new Contact();
            contact.setContactType(systemAccount.getContactType());
            contact.setFirstName(systemAccount.getFirstName());
            contact.setLastName(systemAccount.getLastName());
            contact.setMiddleName(systemAccount.getMiddleName());
            List<Flat> flats = new ArrayList<>();
            flats.add(flatOptional.get());
            contact.setFlats(flats);
            Account account = new Account();
            account.setConfirmed(false);
            account.setActive(true); //Х.З что такое, но пусть будет тру.
            account.setLogin(systemAccount.getLogin());
            account.setPasswordHash(encoder.encode(systemAccount.getPassword()));
            account.setContact(contact);
            List<Role> roles = new ArrayList<>();
            Optional<Role> roleOptional = roleRepository.findRoleByDescription("habitant");
            if (roleOptional.isPresent()) {
                roles.add(roleOptional.get());
                account.setRoles(roles);
                contactRepository.save(contact);
                accountRepository.save(account);
                return true;
            }
            //TODO куда-то запихнуть телефон и электрическую почту.

        }
        return false;
    }
}
