package ua.lviv.iot.items.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import com.company.item.Item;

import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.stereotype.Service;

@Service
@ApplicationScope
public class ItemsService {

    private AtomicInteger id = new AtomicInteger(0);

    private Map<Integer, Item> itemsMap = new HashMap<Integer, Item>();

    public Item addItems(Item items) {
        Integer itemsId = id.incrementAndGet();
        items.setId(itemsId);
        itemsMap.put(itemsId, items);
        return items;
    }

    public Item updateItems(Item items) {
        return itemsMap.put(items.getId(), items);
    }

    public List<Item> getItems() {
        return itemsMap.values().stream().collect(Collectors.toList());
    }

    public Item getItems(Integer id) {
        return itemsMap.get(id);
    }

    public void deleteById(Integer id){
        itemsMap.remove(id);
    }
}
