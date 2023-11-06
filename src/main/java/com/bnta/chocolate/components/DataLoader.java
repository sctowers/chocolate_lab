package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateServices estateServices;

    @Autowired
    ChocolateRepository chocolateRepository;

    public void run (ApplicationArguments args){
        Estate estate1 = new Estate("Galaxy", "Tanzania");
        Estate estate2 = new Estate("Dairy Milk", "Brazil");
        Estate estate3 = new Estate("Lindt", "Switzerland");

        estateServices.saveEstate(estate1);
        estateServices.saveEstate(estate2);
        estateServices.saveEstate(estate3);

        Chocolate chocolate1 = new Chocolate("milk", 50, estate1);
        Chocolate chocolate2 = new Chocolate("white", 5, estate2);
        Chocolate chocolate3 = new Chocolate("dark", 95, estate3);


        chocolateRepository.save(chocolate1);
        chocolateRepository.save(chocolate2);
        chocolateRepository.save(chocolate3);
    }


}
