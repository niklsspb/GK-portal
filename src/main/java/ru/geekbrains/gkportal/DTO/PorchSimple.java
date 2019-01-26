package ru.geekbrains.gkportal.DTO;

import lombok.Data;
import ru.geekbrains.gkportal.entities.BuildPorchConfig;
import ru.geekbrains.gkportal.entities.Flat;

import java.util.ArrayList;
import java.util.List;

@Data
public class PorchSimple {
    private BuildPorchConfig description;
    private List<Flat> flats = new ArrayList<>();
}
