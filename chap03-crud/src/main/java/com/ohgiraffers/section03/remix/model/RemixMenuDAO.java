package com.ohgiraffers.section03.remix.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface RemixMenuDAO {


    public List<MenuDTO> selectAllMenu();


    public MenuDTO selectByMenuCode(int code) ;


    public int registMenu(MenuDTO menu) ;

    public int modifyMenu(MenuDTO menu);

    public int deleteMenu(int code);

}
