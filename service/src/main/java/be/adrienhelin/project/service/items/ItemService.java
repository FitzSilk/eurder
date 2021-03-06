package be.adrienhelin.project.service.items;

import be.adrienhelin.project.domain.items.Item;
import be.adrienhelin.project.domain.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto addAnItem(ItemDto itemDto) {
        if (checkIfAlreadyExistingItem(itemDto))
            throw new IllegalArgumentException("This item is already registered in the database, try to update it instead? -you moron");
        return itemMapper.toDto(itemRepository.save(itemMapper.toItem(itemDto)));
    }

    public Collection<ItemDto> getAllItems() {
        return itemMapper.toDto(itemRepository.findAll());
    }

    public boolean checkIfAlreadyExistingItem(ItemDto itemDto) {
        Optional<Item> sameItem = itemRepository.findAll().stream()
                .filter(item -> item.getName().equals(itemDto.getName()))
                .filter(item -> item.getDescription().equals(itemDto.getDescription()))
                .findFirst();
        return sameItem.isPresent();
    }

    public ItemDto getItemById(Integer id) {
        Optional<Item> fetchItem = itemRepository.findById(id);
        if (fetchItem.isEmpty()) throw new IllegalArgumentException("This item doesn't exists");
        else return itemMapper.toDto(fetchItem.get());
    }

    public ItemDto updateAnItem(Integer id, ItemDto itemDto) {
        Optional<Item> fetchItem = itemRepository.findById(id);
        if (fetchItem.isEmpty())
            throw new IllegalArgumentException("This item doesn't exists and so can't be updated.");
        else {
            return itemMapper.toDto(itemRepository.save(itemMapper.toItem(itemDto)));
        }
    }

    public Collection<ItemDto> getItemsStock() {
        List<Item> allItems = itemRepository.findAll();
        Collections.sort(allItems);
        return itemMapper.toDto(allItems);
    }

    public Collection<ItemDto> getFilteredItemsStock(String filter) {
        List<Item> allItems = itemRepository.findAll()
                .stream()
                .filter(itemDto -> itemDto.getStock().toString().equals(filter.toUpperCase()))
                .collect(Collectors.toList());
        return itemMapper.toDto(allItems);
    }

    public void deleteAnItem(Integer id) {
        itemRepository.deleteById(id);
    }
}
