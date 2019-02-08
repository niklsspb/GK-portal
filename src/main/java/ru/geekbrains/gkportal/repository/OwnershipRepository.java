package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.Ownership;

@Repository
public interface OwnershipRepository extends JpaRepository<Ownership, String> {
    Ownership findByBuildNumberAndHouseBuildNum(Integer buildNumber, Integer houseBuildNum);
}
