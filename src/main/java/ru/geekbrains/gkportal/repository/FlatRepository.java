package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entities.Flat;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Integer> {

}
