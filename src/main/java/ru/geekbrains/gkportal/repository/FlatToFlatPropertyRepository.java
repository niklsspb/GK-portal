package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.FlatToFlatProperty;

@Repository
public interface FlatToFlatPropertyRepository extends JpaRepository<FlatToFlatProperty, String> {
}
