package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.section01.xmlconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;

import static com.ohgiraffers.common.Template.*;
public class Application {

    public static void main(String[] args){
        // 처음에 세션이 잘 연결되는지 확인 먼저해야 함.
//        System.out.println(getSqlSession());

        MenuController menuController = new MenuController();
        Map<String, String> test = new HashMap<>();
        test.put("name", "테스트메뉴");
        test.put("code" , "4");
        test.put("status", "Y");
        test.put("price", "3000");
        test.put("category", "4");

//        menuController.modifyMenu(test);
//        menuController.deleteMenu(4);
        menuController.selectAllMenu();
    }
}
