package ua.lviv.iot.rest.models.item;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


public class ClothesItems extends Item {
    private Season season;
    private float temperature;

    public ClothesItems(String name, String brand, float price, Country originCountry,
                        Material material, Gender gender, String size, String typeOfSport,
                        Season season, float temperature) {
        super(name, brand, price, originCountry, material, gender, size, typeOfSport);

        this.season = season;
        this.temperature = temperature;
    }
}
