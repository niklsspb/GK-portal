package ru.geekbrains.gkportal.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.gkportal.dto.SystemAccount;
import ru.geekbrains.gkportal.entity.Account;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.Role;
import ru.geekbrains.gkportal.repository.AccountRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AccountService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(AccountService.class);

    private AccountRepository accountRepository;
    private BCryptPasswordEncoder encoder;
    private ContactService contactService;

    private RoleService roleService;
    private AuthenticateService authenticateService;

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setAuthenticateService(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }


    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public boolean isLoginExist(String login) {
        return accountRepository.findOneByLogin(login) != null;
    }

    @Transactional
    public void createAccount(SystemAccount systemAccount) throws Throwable {
        accountRepository.save(Account.builder()
                .confirmed(false)
                .active(false)
                .login(systemAccount.getEmail())
                .passwordHash(encoder.encode(systemAccount.getPassword()))
                .contact(contactService.getOrCreateContact(systemAccount))
                .roles(roleService.getDefaultRoleList())
                .build());
    }


    public boolean confirmAccount(Contact contact) {
        Account account = accountRepository.findByContact(contact);
        if (account != null) {
            account.setConfirmed(true);
            account.setActive(true);
            accountRepository.save(account);
            return true;
        } else return false;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findOneByLogin(login);
        if (account == null) {
            if (logger.isDebugEnabled()){
                logger.debug("Invalid username or password");
            }
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(account.getLogin(), account.getPasswordHash(),
                mapRolesToAuthorities(account.getRoles()));
    }


    @Transactional
    public Contact getContactByLogin(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findOneByLogin(login);

        if (account == null) {
            if (logger.isDebugEnabled()){
                logger.debug("Invalid username or password");
            }
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return account.getContact();
    }


    public Contact getCurrentContact() throws UsernameNotFoundException {
        User user = authenticateService.getCurrentUser();
        if (user == null) throw new UsernameNotFoundException("Пользователь не авторизирован");
        return getContactByLogin(user.getUsername());
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getDescription())).collect(Collectors.toList());
    }
}
