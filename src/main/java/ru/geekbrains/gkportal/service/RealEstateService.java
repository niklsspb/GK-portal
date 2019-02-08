package ru.geekbrains.gkportal.service;


import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.questionnaire.RealEstate;
import ru.geekbrains.gkportal.repository.RealEstateRepository;

@Service
public class RealEstateService {

    private RealEstateRepository repository;

    public void setRepository(RealEstateRepository repository) {
        this.repository = repository;
    }

    public RealEstate findByBuildNumberAndHouseBuildNum(Integer buildNumber, Integer houseBuildNum) {
        return repository.findByBuildNumberAndHouseBuildNum(buildNumber, houseBuildNum);
    }

//    public RealEstate getRealEstate(AnswerResultDTO answerResultDTO) {
//
//    }

}
