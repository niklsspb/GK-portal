package ru.geekbrains.gkportal.service;


import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.Ownership;
import ru.geekbrains.gkportal.repository.OwnershipRepository;

@Service
public class OwnershipService {

    private OwnershipRepository repository;

    public void setRepository(OwnershipRepository repository) {
        this.repository = repository;
    }

    public Ownership findByBuildNumberAndHouseBuildNum(Integer buildNumber, Integer houseBuildNum) {
        return repository.findByBuildNumberAndHouseBuildNum(buildNumber, houseBuildNum);
    }

//    public Ownership getRealEstate(AnswerResultDTO answerResultDTO) {
//
//    }

}
