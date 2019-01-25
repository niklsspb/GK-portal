package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlatRepository<Flat, Integer> extends JpaRepository {
    List<Flat> findAllByHouse(int house);
    List<Flat> findAllByHouseAndPorch(int house, int porch);

}
