package ru.geekbrains.gkportal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.gkportal.dto.FlatDTO;
import ru.geekbrains.gkportal.service.HouseService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/rest")
public class HouseRestController {



    private HouseService houseService;

    @Autowired
    public void setHouseService(HouseService houseService) {
        this.houseService = houseService;
    }


    @PutMapping(value = "/flat")
    public int changeFlat (@RequestBody FlatDTO flatDTO, HttpServletResponse response) {
        System.out.println(flatDTO);
        if(houseService.changeFlat(flatDTO)!=null){
            return HttpStatus.OK.value();
        }
        else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return HttpStatus.BAD_REQUEST.value();
        }

    }


}
