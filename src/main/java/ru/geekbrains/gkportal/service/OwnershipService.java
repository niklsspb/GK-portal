package ru.geekbrains.gkportal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.dto.OwnershipRegDTO;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.Ownership;
import ru.geekbrains.gkportal.repository.OwnershipRepository;

@Service
public class OwnershipService {

    private OwnershipRepository ownershipRepository;
    private OwnershipTypeService ownershipTypeService;


    @Autowired
    public void setOwnershipRepository(OwnershipRepository ownershipRepository) {
        this.ownershipRepository = ownershipRepository;
    }

    public Ownership findByBuildNumberAndHouseBuildNum(Integer buildNumber, Integer houseBuildNum) {
        return ownershipRepository.findByBuildNumberAndHouseBuildNum(buildNumber, houseBuildNum);
    }

    public Ownership createOrGetOwnership(OwnershipRegDTO ownershipRegDTO, Contact contact, boolean isBuildNumbers) {
        Ownership ownership;
        if (isBuildNumbers)
            ownership = ownershipRepository.findByOwnershipTypeAndContactAndHouseBuildNumAndBuildNumber(ownershipRegDTO.getOwnershipType()
                    , contact, ownershipRegDTO.getHousingNumber(), ownershipRegDTO.getFlatNumber());
        else
            ownership = ownershipRepository.findByOwnershipTypeAndContactAndHouseNumAndNumber(ownershipRegDTO.getOwnershipType()
                    , contact, ownershipRegDTO.getHousingNumber(), ownershipRegDTO.getFlatNumber());

        if (ownership == null) {
            ownership = Ownership.builder().ownershipType(ownershipRegDTO.getOwnershipType()).is_build_num(isBuildNumbers).
                    contact(contact).percentageOfOwner(ownershipRegDTO.getPercentageOfOwner()).square(ownershipRegDTO.getSquare()).build();
            if (isBuildNumbers) {
                ownership.setHouseBuildNum(ownershipRegDTO.getHousingNumber());
                ownership.setBuildNumber(ownershipRegDTO.getFlatNumber());
            } else {
                ownership.setHouseNum(ownershipRegDTO.getHousingNumber());
                ownership.setNumber(ownershipRegDTO.getFlatNumber());
            }
        }
        return ownership;
    }

//    public Ownership getRealEstate(AnswerResultDTO answerResultDTO) {
//
//    }

}
