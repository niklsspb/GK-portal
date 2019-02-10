package ru.geekbrains.gkportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.OwnershipType;
import ru.geekbrains.gkportal.repository.OwnershipTypeRepository;

import java.util.List;

@Service
public class OwnershipTypeService {
    private OwnershipTypeRepository ownershipTypeRepository;
    public static final String FLAT_TYPE_UUID = "d2512bfc-620b-46fe-a6b1-e8a585ff0bb6";
    public static final String PREMISES_TYPE_UUID = "54fb4d35-f746-44d6-963c-7205e47afb97";

    @Autowired
    public void setOwnershipTypeRepository(OwnershipTypeRepository ownershipTypeRepository) {
        this.ownershipTypeRepository = ownershipTypeRepository;
    }


    public List<OwnershipType> getAllOwnershipTypes() {
        List<OwnershipType> ownershipTypeList = ownershipTypeRepository.findAll();
        return ownershipTypeList;
    }

    public List<OwnershipType> getAllOwnershipTypesByIsUseInQuestionnaire() {
        List<OwnershipType> ownershipTypeList = ownershipTypeRepository.findAllByIsUseInQuestionnaire(true);
        return ownershipTypeList;
    }



    public OwnershipType getOwnershipTypeByName(String name) {
        return ownershipTypeRepository.findByName(name).get();
    }

    public OwnershipType getOwnershipTypeByID(String id) {
        return ownershipTypeRepository.findById(id).get();
    }

}
