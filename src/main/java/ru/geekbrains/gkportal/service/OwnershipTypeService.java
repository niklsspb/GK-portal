package ru.geekbrains.gkportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.OwnershipType;
import ru.geekbrains.gkportal.repository.OwnershipTypeRepository;

import java.util.List;

@Service
public class OwnershipTypeService {
    private OwnershipTypeRepository ownershipTypeRepository;

    @Autowired
    public void setOwnershipTypeRepository(OwnershipTypeRepository ownershipTypeRepository) {
        this.ownershipTypeRepository = ownershipTypeRepository;
    }


    public List<OwnershipType> getAllOwnershipTypes() {
        List<OwnershipType> ownershipTypeList = ownershipTypeRepository.findAll();
        return ownershipTypeList;
    }

    public OwnershipType getOwnershipTypeByName(String name) {
        return ownershipTypeRepository.findByName(name).get();
    }
}
