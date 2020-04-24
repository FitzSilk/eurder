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
    public Collection<ItemDto> getAllCustomers() {
        itemLogger.info("Someone is checking the data here.");
        return itemService.getAllItems();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addAnItem(@RequestBody ItemDto itemDto) {
        itemLogger.info("Adding a new item");
        return itemService.addAnItem(itemDto);
    }

}
