package com.ohgiraffers.section02.javaconfig.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section02.javaconfig.model.JavaMenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section02.javaconfig.template.JavaConfigTemplate.getJavaSqlSession;

public class MenuService {

    private JavaMenuDAO menuDAO;


    public List<MenuDTO> selectAllMenu(){
        SqlSession session = getJavaSqlSession();

        menuDAO = session.getMapper(JavaMenuDAO.class);
        List<MenuDTO> menuList = menuDAO.selectAllMenu(session);

        session.close();

        return menuList;
    }

    public MenuDTO selectByMenuCode(int code) {
        SqlSession session = getJavaSqlSession();
        menuDAO = session.getMapper(JavaMenuDAO.class);
        MenuDTO menu = menuDAO.selectByMenuCode(code);
        session.close();
        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession session = getJavaSqlSession();
        menuDAO = session.getMapper(JavaMenuDAO.class);

        int result = menuDAO.registMenu(menu);
        if(result > 0){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result > 0? true : false;
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession session = getJavaSqlSession();
        menuDAO = session.getMapper(JavaMenuDAO.class);

        int result = menuDAO.modifyMenu(session, menu);
        if(result > 0){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result > 0? true : false;
    }

    public boolean deleteMenu(int code) {
        SqlSession session = getJavaSqlSession();
        menuDAO = session.getMapper(JavaMenuDAO.class);
        int result = menuDAO.deleteMenu(session, code);
        if (result > 0) {
            session.commit();
        }else {
            session.rollback();
        }
        session.close();

        return result > 0 ? true : false;
    }
}
