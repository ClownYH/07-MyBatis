package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.model.MenuDTO;
import com.ohgiraffers.common.model.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.*;
public class MenuService {

    private DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price){
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);

        List<MenuDTO> menuList = mapper.selectMenuByPrice(map);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 경로가 없습니다.");
        }

        session.close();
    }

    public void searchMenu(SearchCriteria searchCriteria){
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 경로가 없습니다.");
        }

        session.close();
    }

    public void searchMenuBySubCategory(SearchCriteria searchCriteria){
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuBySubCategory(searchCriteria);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 경로가 없습니다.");
        }

        session.close();
    }

    public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList){
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> codeList = new HashMap<>();
        codeList.put("randomMenuCodeList", randomMenuCodeList);
        List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(codeList);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 경로가 없습니다.");
        }

        session.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria criteria){
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(criteria);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 경로가 없습니다.");
        }

        session.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria){
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(criteria);

        if(menuList != null && menuList.size() > 0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 경로가 없습니다.");
        }

        session.close();
    }

    public void modifyMenu(Map<String, Object> criteria){
        SqlSession session = getSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        int result = mapper.modifyMenu(criteria);

        if(result > 0){
            System.out.println("수정 성공");
            session.commit();
        }else {
            System.out.println("수정 실패");
            session.rollback();
        }

        session.close();
    }
}
