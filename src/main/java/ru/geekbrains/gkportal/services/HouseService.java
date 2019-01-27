package ru.geekbrains.gkportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.DTO.*;
import ru.geekbrains.gkportal.entities.BuildPorchConfig;
import ru.geekbrains.gkportal.entities.Flat;
import ru.geekbrains.gkportal.repository.BuildPorchConfigRepository;
import ru.geekbrains.gkportal.repository.FlatRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseService {
    private FlatRepository flatRepository;
    private BuildPorchConfigRepository porchConfigRepository;

    @Autowired
    public void setPorchConfigRepository(BuildPorchConfigRepository porchConfigRepository) {
        this.porchConfigRepository = porchConfigRepository;
    }

    @Autowired
    public void setFlatRepository(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    public House build(int houseNumber) {
        List<BuildPorchConfig> porchConfigs = porchConfigRepository.findAllByhousingID(houseNumber);
        List<Flat> flats = flatRepository.findAllByHouse(houseNumber);
        House house = new House();
        house.setNumber(houseNumber);
        for (BuildPorchConfig config : porchConfigs
        ) {
            Porch porch = new Porch();
            porch.setDescription(config);
            for (int i = config.getFloorsCount(); i >= 1; i--) {
                Floor floor = new Floor();
                int w = i;
                floor.setNumber(w);
                List<Flat> floorFlats = flats.parallelStream().filter(f -> f.getFloor() == w)
                        .filter(f -> f.getPorch() == config.getPorchID())
                        //.sorted(Comparator.comparing(Flat::getRiser))
                        .collect(Collectors.toList());
                floor.getFlats().addAll(floorFlats);
                flats.removeAll(floorFlats);
                porch.getFloors().add(floor);
            }
            house.getPorchList().add(porch);
        }
        return house;
    }

    public HouseSimple buildSimple(int houseNumber) {
        List<BuildPorchConfig> porchConfigs = porchConfigRepository.findAllByhousingID(houseNumber);
        List<Flat> flats = flatRepository.findAllByHouse(houseNumber);
        HouseSimple house = new HouseSimple();
        house.setNumber(houseNumber);
        for (BuildPorchConfig config : porchConfigs)
        {
            PorchSimple porch = new PorchSimple();
            porch.setDescription(config);
            flats.stream().filter(f -> f.getPorch() == config.getPorchID())
                    .forEach(porch.getFlats()::add);
            house.getPorchList().add(porch);
        }
        return house;
    }
}
