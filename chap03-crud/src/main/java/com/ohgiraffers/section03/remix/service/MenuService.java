package com.ohgiraffers.section03.remix.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section03.remix.model.RemixMenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getRemixSession;

public class MenuService {

    private RemixMenuDAO menuDAO;


    public List<MenuDTO> selectAllMenu(){
        SqlSession session = getRemixSession();

        menuDAO = session.getMapper(RemixMenuDAO.class);
        List<MenuDTO> menuList = menuDAO.selectAllMenu();

        session.close();

        return menuList;
    }

    public MenuDTO selectByMenuCode(int code) {
        SqlSession session = getRemixSession();
        menuDAO = session.getMapper(RemixMenuDAO.class);
        MenuDTO menu = menuDAO.selectByMenuCode(code);
        session.close();
        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession session = getRemixSession();
        menuDAO = session.getMapper(RemixMenuDAO.class);

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
        SqlSession session = getRemixSession();
        menuDAO = session.getMapper(RemixMenuDAO.class);

        int result = menuDAO.modifyMenu(menu);
        if(result > 0){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result > 0? true : false;
    }

    public boolean deleteMenu(int code) {
        SqlSession session = getRemixSession();
        menuDAO = session.getMapper(RemixMenuDAO.class);
        int result = menuDAO.deleteMenu(code);
        if (result > 0) {
            session.commit();
        }else {
            session.rollback();
        }
        session.close();

        return result > 0 ? true : false;
    }
}
