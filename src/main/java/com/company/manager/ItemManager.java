package com.company.manager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import com.company.item.Item;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor

public class ItemManager {
    public List<Item> itemList;

    public ItemManager(List<Item> items) {
        itemList = items;
    }

    public List<Item> sortByPrice(final boolean reverse) {
        if (reverse) {
            itemList.sort((Item i1, Item i2) -> Float.compare(i2.getPrice(), i1.getPrice()));
        } else {
            itemList.sort((Item i1, Item i2) -> Float.compare(i1.getPrice(), i2.getPrice()));
        }
        return itemList;
    }

    public List<Item> sortBySize(final boolean reverse) {
        if (reverse) {
            itemList.sort((Item i1, Item i2) -> i1.getSize().compareTo(i2.getSize()));
        } else {
            itemList.sort((Item i1, Item i2) -> i2.getSize().compareTo(i1.getSize()));
        }
        return itemList;
    }

    public List<Item> searchByTypeOfSport(String typeOfSport) {
        return itemList.stream().filter(item -> item.getTypeOfSport().equals(typeOfSport)).collect(Collectors.toList());
    }
}
