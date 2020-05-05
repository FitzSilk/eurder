package be.adrienhelin.project.api.controllers;

import be.adrienhelin.project.service.items.ItemDto;
import be.adrienhelin.project.service.items.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = ItemController.ITEM_RESOURCE_PATH)
public class ItemController {

    public static final String ITEM_RESOURCE_PATH = "/item";
    private ItemService itemService;
    private final Logger itemLogger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<ItemDto> getAllItems() {
        itemLogger.info("getallItems");
        return itemService.getAllItems();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    public ItemDto getItemById(@PathVariable Integer id) {
        itemLogger.info("getItemById");
        return itemService.getItemById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://localhost:4200")
    public ItemDto addAnItem(@RequestBody ItemDto itemDto) {
        itemLogger.info("Adding a new item");
        return itemService.addAnItem(itemDto);
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    public ItemDto updateAnItem(@PathVariable Integer id, @RequestBody ItemDto itemDto) {
        itemLogger.info("Tryin' to update item: " + id);
        return itemService.updateAnItem(id, itemDto);
    }

    @DeleteMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteAnItem(@PathVariable Integer id) {
        itemLogger.info("Tryin' to delete item: " + id);
        itemService.deleteAnItem(id);
    }

    @GetMapping(path = "/stock", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<ItemDto> getItemsStock() {
        itemLogger.info("getItemsStock");
        return itemService.getItemsStock();
    }

    @GetMapping(path = "/stock/{filter}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<ItemDto> getFilteredItemsStock(@PathVariable String filter) {
        itemLogger.info("getFilteredItemsStock");
        return itemService.getFilteredItemsStock(filter);
    }

}
