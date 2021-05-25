package ua.lviv.iot.rest.models;

import ua.lviv.iot.rest.models.item.*;
import ua.lviv.iot.rest.models.manager.ItemManager;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ItemManager manager = new ItemManager(new ArrayList<Item>());
        manager.getItemList().add(new SportEquipment("Helmet", "Nike", 100.5f,
                Country.China, Material.Cotton, Gender.Female,
                "A++", "Golf", "200300", true));
        manager.getItemList().add(new SportFood("SuperProtein", "Nutella", 108.5f,
                Country.USA, null, Gender.Undefined,
                "FamilyPack", "Football", "200300", "100kk"));
        manager.getItemList().add(new ClothesItems("Gloves", "Abibas", 155.5f,
                Country.Vietnam, Material.Polyester, Gender.Male,
                "FamilyPack", "Football", Season.Autumn, -10.5f));

        manager.searchByTypeOfSport("Golf").forEach(item -> System.out.println(item));
        manager.sortByPrice(true).forEach(System.out::println);
        manager.sortBySize(true).forEach(System.out::println);
    }
}
