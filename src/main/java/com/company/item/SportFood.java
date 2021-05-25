package com.company.item;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


public class SportFood extends Item {
    private String mainComponent;
    private String nutritionalValue;

    public SportFood(String name, String brand, float price, Country originCountry,
                     Material material, Gender gender, String size, String typeOfSport,
                     String mainComponent, String nutritionalValue) {
        super(name, brand, price, originCountry, material, gender, size, typeOfSport);

        this.mainComponent = mainComponent;
        this.nutritionalValue = nutritionalValue;
    }
}
