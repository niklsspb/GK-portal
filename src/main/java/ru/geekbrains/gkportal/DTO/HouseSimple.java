package ru.geekbrains.gkportal.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HouseSimple {
    private int number;
    private List<PorchSimple> porchList = new ArrayList<>();
}
