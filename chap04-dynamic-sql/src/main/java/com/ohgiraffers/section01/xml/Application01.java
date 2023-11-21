package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.model.SearchCriteria;

import java.util.*;

import static com.ohgiraffers.common.Template.*;
public class Application01 {

    public static void main(String[] args){


        MenuService menuService = new MenuService();
//        menuService.selectMenuByPrice(10000);
//
        SearchCriteria criteria = new SearchCriteria("menuCode", "1");
//        menuService.searchMenuBySubCategory(criteria);

//        menuService.searchMenuByRandomMenuCode(createRandomMenuCodeList());

//        menuService.searchMenuByCodeOrSearchAll(criteria); // 매개변수를 넣지 않으면 전체 검색

        Map<String, Object> test = new HashMap<>();
//        test.put("name", "보리");
//        test.put("categoryCode", "5");
        test.put("orderableStatus", "N");
        test.put("code", "1");
//        test.put("categoryValue", "5");
        // 만약 nameValue 조건에만 where을 포함할 경우 이 조건을 에러를 일으킨다.
        // 그래서 매퍼에서 WHERE 1=1 조건을 우선적으로 집어 넣어 실행이 가능케 하지만 올바른 방법이라고 할 수는 없다.
//        menuService.searchMenuByNameOrCategory(test);
        menuService.modifyMenu(test);
    }

    public static List<Integer> createRandomMenuCodeList(){
        Set<Integer> set = new HashSet<>();
        while(set.size() < 5){
            int temp = ((int)(Math.random() * 21)) + 1;
            set.add(temp);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }
}
