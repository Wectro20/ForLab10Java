package ua.lviv.iot.rest.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ua.lviv.iot.rest.exceptions.ItemNotFoundException;
import ua.lviv.iot.rest.service.ItemsService;
import ua.lviv.iot.rest.models.item.Item;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path = "/items")

public class ItemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemsService itemsService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Item> getItem(@PathVariable(name = "id") Integer id) {
        if (itemsService.getItems(id) == null) {
            LOGGER.info("Can't update an item with non-existing id" + id);
            throw new ItemNotFoundException("Item with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        return new ResponseEntity<Item>(itemsService.getItems(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        LOGGER.info("Successfully gave an objects");
        return new ResponseEntity<List<Item>>(itemsService.getItems(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Item> createItems(@Valid @RequestBody Item items) {
        LOGGER.info("Success added item");
        return new ResponseEntity<Item>(itemsService.addItems(items), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Item> updateItems(@Valid @RequestBody Item items) {
        if (itemsService.getItems(items.getId()) == null) {
            LOGGER.info("Can't update Item without id - null value was passed instead of it");
            throw new ItemNotFoundException("Technique with id: " + items.getId() + " not found");
        }
        LOGGER.info("Updated an item with id: " + items.getId());
        return new ResponseEntity<Item>(itemsService.updateItems(items), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable("id") Integer id) {
        if (itemsService.getItems(id) == null) {
            LOGGER.info("Can't delete Item ");
            throw new ItemNotFoundException("Technique with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted Item witn id: " +id);
        itemsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
