package ua.lviv.iot.rest.models.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Missing name")
    private String name;
    @NotNull(message = "Missing brand")
    private String brand;
    @NotNull(message = "Missing price")
    private float price;
    @NotNull(message = "Missing origin country")
    private Country originCountry;
    @NotNull(message = "Missing message")
    private Material material;
    @NotNull(message = "Missing gender")
    private Gender gender;
    @NotNull(message = "Missing size")
    private String size;
    @NotNull(message = "Missing type of sport")
    private String typeOfSport;

    public Item(String name, String brand, float price, Country originCountry, Material material, Gender gender, String size, String typeOfSport) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.originCountry = originCountry;
        this.material = material;
        this.gender = gender;
        this.size = size;
        this.typeOfSport = typeOfSport;
    }

}
