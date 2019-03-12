package ru.geekbrains.gkportal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.FlatProperty;

@Repository
public interface FlatPropertyRepository extends JpaRepository<FlatProperty, String> {

}
