package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.OwnershipType;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnershipTypeRepository extends JpaRepository<OwnershipType, String> {

    Optional<OwnershipType> findByName(String name);

    List<OwnershipType> findAllByIsUseInQuestionnaire(boolean InQuestionnaire);
}
