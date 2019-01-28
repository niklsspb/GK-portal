package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entities.BuildPorchConfig;

import java.util.List;

@Repository
public interface BuildPorchConfigRepository  extends JpaRepository<BuildPorchConfig, BuildPorchConfig.HousingPorchID> {
    List<BuildPorchConfig> findAllByhousingID(int housingID);
}
