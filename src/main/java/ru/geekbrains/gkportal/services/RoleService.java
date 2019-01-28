package ru.geekbrains.gkportal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entities.Role;
import ru.geekbrains.gkportal.repository.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }
}
