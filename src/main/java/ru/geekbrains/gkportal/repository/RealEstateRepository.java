package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.questionnaire.RealEstate;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, String> {
    RealEstate findByBuildNumberAndHouseBuildNum(Integer buildNumber, Integer houseBuildNum);
}
