package com.company.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter


public final class SportEquipment extends Item {
    private String model;
    private boolean professionalism;

    public SportEquipment(String name, String brand, float price, Country originCountry,
                          Material material, Gender gender, String size, String typeOfSport,
                          String model, boolean professionalism) {
        super(name, brand, price, originCountry, material, gender, size, typeOfSport);

        this.model = model;
        this.professionalism = professionalism;
    }
}
