package com.example.start.pattern;

import com.example.start.dto.request.CreateItemRequest;
import com.example.start.entity.Item;
import com.example.start.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;

    public void createItem(CreateItemRequest request) {
        Item item = new Item();
        itemRepository.save(item);
    }
}
