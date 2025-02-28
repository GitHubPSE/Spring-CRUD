package com.example.crud.service;

import com.example.crud.entity.Item;
import com.example.crud.mapper.ItemMapper;
import com.example.crud.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository; // JPA 사용
    private final ItemMapper itemMapper; // MyBatis 사용

    // ✅ JPA: 아이템 저장
    @Transactional
    public Item saveItemWithJPA(Item item) {
        return itemRepository.save(item);
    }

    // ✅ MyBatis: 아이템 저장
    @Transactional
    public void saveItemWithMyBatis(Item item) {
        itemMapper.insert(item);
    }

    // ✅ JPA: 모든 아이템 조회
    public List<Item> getAllItemsWithJPA() {
        return itemRepository.findAll();
    }

    // ✅ MyBatis: 모든 아이템 조회
    public List<Item> getAllItemsWithMyBatis() {
        return itemMapper.findAll();
    }

    // ✅ JPA: 특정 아이템 조회
    public Item getItemByIdWithJPA(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(null);
    }

    // ✅ MyBatis: 특정 아이템 조회
    public Item getItemByIdWithMyBatis(Long id) {
        return itemMapper.findById(id);
    }

    // ✅ JPA: 아이템 업데이트
    @Transactional
    public Item updateItemWithJPA(Long id, Item newItem) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    item.setPrice(newItem.getPrice());
                    return itemRepository.save(item);
                })
                .orElse(null);
    }

    // ✅ MyBatis: 아이템 업데이트
    @Transactional
    public void updateItemWithMyBatis(Long id, Item newItem) {
        newItem.setId(id);
        itemMapper.update(newItem);
    }

    // ✅ JPA: 아이템 삭제
    @Transactional
    public void deleteItemWithJPA(Long id) {
        itemRepository.deleteById(id);
    }

    // ✅ MyBatis: 아이템 삭제
    @Transactional
    public void deleteItemWithMyBatis(Long id) {
        itemMapper.delete(id);
    }
}