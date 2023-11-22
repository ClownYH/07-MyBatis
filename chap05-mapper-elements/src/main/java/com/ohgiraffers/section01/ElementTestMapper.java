package com.ohgiraffers.section01;

import com.ohgiraffers.section01.DTO.MenuAndCategory;
import com.ohgiraffers.section01.DTO.MenuDTO;
import com.ohgiraffers.section01.DTO.collection.CategoryAndMenuDTO;

import java.util.List;

public interface ElementTestMapper {

    List<String> selectCacheTest();

    List<MenuDTO> selectResultMapTest();

    List<MenuDTO> selectResultMapConstructorTest();

    List<MenuAndCategory> selectResultMapAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();

    List<MenuDTO> selectSqlTest();

    int insertNewCategory(MenuAndCategory menuAndCategory);

    int insertNewMenu(MenuAndCategory menuAndCategory);
}
