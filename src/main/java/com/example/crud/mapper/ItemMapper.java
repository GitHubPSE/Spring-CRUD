package com.example.crud.mapper;

import com.example.crud.entity.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemMapper {

    @Select("SELECT * FROM items")
    List<Item> findAll();

    @Select("SELECT * FROM items WHERE id = #{id}")
    Item findById(Long id);

    @Insert("INSERT INTO items (name, price) VALUES (#{name}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Item item);

    @Update("UPDATE items SET name = #{name}, price = #{price} WHERE id = #{id}")
    void update(Item item);

    @Delete("DELETE FROM items WHERE id = #{id}")
    void delete(Long id);
}