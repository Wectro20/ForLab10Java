package ua.lviv.iot.rest.service;

import java.util.List;

import ua.lviv.iot.rest.models.item.Item;
import org.springframework.beans.factory.annotation.Autowired;

import ua.lviv.iot.rest.dal.ItemRepository;

import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.stereotype.Service;
import ua.lviv.iot.rest.exceptions.ItemNotFoundException;

@Service
@ApplicationScope
public class ItemsService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItems(Item items) {
        return itemRepository.save(items);
    }

    public Item updateItems(Item items) {
        if (itemRepository.existsById(items.getId())) {
            return itemRepository.save(items);
        }
        throw new ItemNotFoundException("Item with id:" + items.getId() + "not found in the system.");
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItems(Integer id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        itemRepository.deleteById(id);
    }
}
