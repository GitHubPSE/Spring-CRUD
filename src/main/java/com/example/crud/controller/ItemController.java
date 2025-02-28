package com.example.crud.controller;

import com.example.crud.entity.Item;
import com.example.crud.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // ✅ JPA: 아이템 저장
    @PostMapping("/jpa")
    public ResponseEntity<Item> createItemWithJPA(@Valid @RequestBody Item item) {
        return ResponseEntity.ok(itemService.saveItemWithJPA(item));
    }

    // ✅ MyBatis: 아이템 저장
    @PostMapping("/mybatis")
    public ResponseEntity<String> createItemWithMyBatis(@Valid @RequestBody Item item) {
        itemService.saveItemWithMyBatis(item);
        return ResponseEntity.ok("Item saved with MyBatis");
    }

    // ✅ JPA: 모든 아이템 조회
    @GetMapping("/jpa")
    public ResponseEntity<List<Item>> getAllItemsWithJPA() {
        return ResponseEntity.ok(itemService.getAllItemsWithJPA());
    }

    // ✅ MyBatis: 모든 아이템 조회
    @GetMapping("/mybatis")
    public ResponseEntity<List<Item>> getAllItemsWithMyBatis() {
        return ResponseEntity.ok(itemService.getAllItemsWithMyBatis());
    }

    // ✅ JPA: 특정 아이템 조회
    @GetMapping("/jpa/{id}")
    public ResponseEntity<Item> getItemByIdWithJPA(@PathVariable Long id) {
        Item item = itemService.getItemByIdWithJPA(id);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    // ✅ MyBatis: 특정 아이템 조회
    @GetMapping("/mybatis/{id}")
    public ResponseEntity<Item> getItemByIdWithMyBatis(@PathVariable Long id) {
        Item item = itemService.getItemByIdWithMyBatis(id);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    // ✅ JPA: 아이템 업데이트
    @PutMapping("/jpa/{id}")
    public ResponseEntity<Item> updateItemWithJPA(@PathVariable Long id, @Valid @RequestBody Item newItem) {
        Item updatedItem = itemService.updateItemWithJPA(id, newItem);
        return updatedItem != null ? ResponseEntity.ok(updatedItem) : ResponseEntity.notFound().build();
    }

    // ✅ MyBatis: 아이템 업데이트
    @PutMapping("/mybatis/{id}")
    public ResponseEntity<String> updateItemWithMyBatis(@PathVariable Long id, @Valid @RequestBody Item newItem) {
        itemService.updateItemWithMyBatis(id, newItem);
        return ResponseEntity.ok("Item updated with MyBatis");
    }

    // ✅ JPA: 아이템 삭제
    @DeleteMapping("/jpa/{id}")
    public ResponseEntity<Void> deleteItemWithJPA(@PathVariable Long id) {
        itemService.deleteItemWithJPA(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ MyBatis: 아이템 삭제
    @DeleteMapping("/mybatis/{id}")
    public ResponseEntity<Void> deleteItemWithMyBatis(@PathVariable Long id) {
        itemService.deleteItemWithMyBatis(id);
        return ResponseEntity.noContent().build();
    }
}