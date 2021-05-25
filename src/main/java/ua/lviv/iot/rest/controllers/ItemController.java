package ua.lviv.iot.rest.controllers;


import ua.lviv.iot.rest.exceptions.ItemNotFoundException;
import ua.lviv.iot.rest.service.ItemsService;
import ua.lviv.iot.rest.models.item.Item;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping(path = "/items")

public class ItemController {
    private static final Logger LOGGER = Logger.getLogger("ua.lviv.iot.items.controllers.ItemController");

    @Autowired
    private ItemsService itemsService;

    @GetMapping(path = "/{id}")
    public Item getItem(@PathVariable(name = "id") Integer id) {
        if (itemsService.getItems(id) == null) {
            LOGGER.severe("Can't update an item with non-existing id" + id);
            throw new ItemNotFoundException("Item with id: " + id + " not found");
        }
        return itemsService.getItems(id);
    }

    @GetMapping
    public List<Item> getItems() {
        return itemsService.getItems();
    }

    @PostMapping
    public Item createItems(@Valid @RequestBody Item items) {
        LOGGER.severe("Failed to create an item with passed id. Item creation should not use external ids. ");
        return itemsService.addItems(items);
    }

    @PutMapping
    public Item updateItems(@Valid @RequestBody Item items) {
        if (itemsService.getItems(items.getId()) == null) {
            LOGGER.severe("Can't update Item without id - null value was passed instead of it");
            throw new ItemNotFoundException("Technique with id: " + items.getId() + " not found");
        }
        LOGGER.severe("Can't update an item with non-existing id: " + items.getId());
        return itemsService.updateItems(items);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteItem(@PathVariable("id") Integer id) {
        if (itemsService.getItems(id) == null) {
            throw new ItemNotFoundException("Technique with id: " + id + " not found");
        }
        itemsService.deleteById(id);
    }
}
