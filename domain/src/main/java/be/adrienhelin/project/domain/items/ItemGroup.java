package be.adrienhelin.project.domain.items;

import java.time.LocalDate;

public class ItemGroup {

    private final String itemId;
    private final double amount;
    private final LocalDate shippingDate;
    private final ItemRepository itemRepository;

    public ItemGroup(String itemId, double amount, ItemRepository itemRepository) {
        this.itemId = itemId;
        this.amount = amount;
        this.itemRepository = itemRepository;
        if((itemRepository.getItemById(itemId)).getAmount() != 0) this.shippingDate = (LocalDate.now()).plusDays(1);
        else this.shippingDate = (LocalDate.now()).plusDays(7);
    }
}
