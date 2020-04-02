package be.adrienhelin.project.service.items;

import be.adrienhelin.project.domain.items.Item;
import be.adrienhelin.project.domain.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto addAnItem(CreateItemDto itemDto) {
        return itemMapper.toDto(itemRepository.addAnItem(itemMapper.toItem(itemDto)));
    }

    public Collection<ItemDto> getAllItems() {
        return itemMapper.toDto(itemRepository.getAllItems());
    }
}
