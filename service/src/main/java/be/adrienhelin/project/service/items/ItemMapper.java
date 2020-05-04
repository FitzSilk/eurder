package be.adrienhelin.project.service.items;

import be.adrienhelin.project.domain.items.Item;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

import static be.adrienhelin.project.domain.items.Item.ItemBuilder.itemBuilder;

@Component
public class ItemMapper {

    public ItemDto toDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getAmount(),
                item.getVisualLink()
        );
    }

    public Collection<ItemDto> toDto(Collection<Item> items) {
        return items.stream()
                .map(this::toDto)
                .collect(Collectors.toList()
                );
    }

    public Item toItem(ItemDto itemDto) {
        return itemBuilder()
                .withId(itemDto.getId())
                .withName(itemDto.getName())
                .withDescription(itemDto.getDescription())
                .withPrice(itemDto.getPrice())
                .withAmount(itemDto.getAmount())
                .withVisualLink(itemDto.getVisualLink())
                .build();
    }

}
