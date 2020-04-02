package be.adrienhelin.project.domain.items;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {

    private final ConcurrentHashMap<String, Item> itemRepository;

    public ItemRepository() {
        this.itemRepository = new ConcurrentHashMap<>();
    }

    public Item addAnItem(Item item) {
        itemRepository.put(item.getId(), item);
        return item;
    }

    public Collection<Item> getAllItems() {
        return itemRepository.values();
    }
}
