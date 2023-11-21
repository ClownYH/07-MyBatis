package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.section02.javaconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;

import static com.ohgiraffers.section02.javaconfig.template.JavaConfigTemplate.*;

public class Application {

    public static void main(String[] args){

        MenuController menuController = new MenuController();

        Map<String, String> value = new HashMap<>();
        value.put("name", "보리새우 떡볶이");
        value.put("price", "5000");
        value.put("category", "5");
        menuController.registMenu(value);

        menuController.selectAllMenu();
    }
}
