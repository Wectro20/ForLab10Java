package ua.lviv.iot.items.controllers;


import ua.lviv.iot.items.service.ItemsService;
import com.company.item.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/items")

public class ItemController {
    @Autowired
    private ItemsService itemsService;

    @GetMapping(path = "/{id}")
    public Item getItems(@PathVariable(name = "id") Integer id) {
        return itemsService.getItems(id);
    }

    @GetMapping
    public List<Item> getItems() {
        return itemsService.getItems();
    }

    @PostMapping
    public Item createItems(@Valid @RequestBody Item items) {
        return itemsService.addItems(items);
    }

    @PutMapping
    public ResponseEntity<Item> updateItems(@Valid @RequestBody Item items) {
        if (itemsService.getItems(items.getId()) != null) {
            return new ResponseEntity<Item>(itemsService.updateItems(items), HttpStatus.OK);
        } else {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deleteItem(@PathVariable("id") Integer id) {
        itemsService.deleteById(id);
    }
}
