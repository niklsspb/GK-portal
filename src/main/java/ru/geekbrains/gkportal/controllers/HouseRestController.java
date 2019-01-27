package ru.geekbrains.gkportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.gkportal.DTO.FlatDTO;
import ru.geekbrains.gkportal.services.HouseService;

@RestController
@RequestMapping("/rest")
public class HouseRestController {



    private HouseService houseService;

    @Autowired
    public void setHouseService(HouseService houseService) {
        this.houseService = houseService;
    }

    @PutMapping("/flat")
    public int changeFlat (@RequestBody FlatDTO flatDTO) {
        houseService.changeFlat(flatDTO);
        return HttpStatus.OK.value();
    }


}
