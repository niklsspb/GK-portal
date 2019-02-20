package ru.geekbrains.gkportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.gkportal.entity.BuildPorchConfig;

import java.util.List;

@Repository
public interface BuildPorchConfigRepository
        extends JpaRepository<BuildPorchConfig, BuildPorchConfig.HousingPorchID> {
    List<BuildPorchConfig> findAllByhousingID(int housingID);

    BuildPorchConfig findAllByhousingIDAndPorchID(int housingID, int porchID);

    @Query(
            value = "select distinct housing from build_porch_config", nativeQuery = true
    )
    List<String> findallDistinctHousingID();

    @Query(
            value = "select count(porch) from build_porch_config where housing = :housingID",
            nativeQuery = true
    )
    Integer getCountporchIDByHousingID(@Param("housingID")int housingID);

    @Query(
            value = "select count(porch) from build_porch_config where build_housing = :housingID",
            nativeQuery = true
    )
    Integer getCountporchIDByBuildHousingID(@Param("housingID")int housingID);

    @Query(
            value = "select porch from build_porch_config where housing = :housingID",
            nativeQuery = true
    )
    List<Integer> getPorchNumbersByHousingID(@Param("housingID")int housingID);
}
