package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.Ownership;
import ru.geekbrains.gkportal.entity.OwnershipType;

@Repository
public interface OwnershipRepository extends JpaRepository<Ownership, String> {

    Ownership findByBuildNumberAndHouseBuildNum
            (
                    Integer buildNumber,
                    Integer houseBuildNum
            );

    Ownership findByOwnershipTypeAndContactAndHouseBuildNumAndBuildNumber
            (
                    OwnershipType ownershipType,
                    Contact contact,
                    Integer houseBuildNum,
                    String buildNumber
            );

    Ownership findByOwnershipTypeAndContactAndHouseNumAndNumber
            (
                    OwnershipType ownershipType,
                    Contact contact,
                    Integer houseNum,
                    String Number
            );
}
