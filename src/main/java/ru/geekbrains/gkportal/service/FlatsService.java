package ru.geekbrains.gkportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.Flat;
import ru.geekbrains.gkportal.entity.SystemAccount;
import ru.geekbrains.gkportal.exception.FlatNotFoundException;
import ru.geekbrains.gkportal.repository.FlatRepository;

import java.util.function.Supplier;

@Service
public class FlatsService {

    private FlatRepository flatRepository;

    @Autowired
    public void setFlatRepository(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }


    public Flat createFlat(SystemAccount systemAccount) throws Throwable {

        return flatRepository.findByHouseAndPorchAndFloorAndFlatNumber(
                systemAccount.getHousingNumber(),
                systemAccount.getPorchNumber(),
                systemAccount.getFloorNumber(),
                systemAccount.getFlatNumber()
        ).orElseThrow((Supplier<Throwable>) () -> new FlatNotFoundException(systemAccount));

    }
}
