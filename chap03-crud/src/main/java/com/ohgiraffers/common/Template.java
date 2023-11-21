package com.ohgiraffers.common;

import com.ohgiraffers.section02.javaconfig.model.JavaMenuDAO;
import com.ohgiraffers.section03.remix.model.RemixMenuDAO;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Template {

    private static SqlSessionFactory sessionFactory; // 원래 싱글톤을 쓸 때는 생성자를 이렇게 많이 만들어 모아두지 않지만, 비교를 위해 모아둠

    public static SqlSession getSqlSession(){ // Section01 xmlcinfig 설정
        if(sessionFactory == null){
            try {
                InputStream inputStream = Resources.getResourceAsStream("xmlconfig/mybatis-config.xml");
                sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return sessionFactory.openSession(false);
    }

    public static SqlSession getJavaSqlSession(){ // Section02 javaconfig 설정
        // 자바 설정은 잘 쓰는 방식은 아니다. 단, xml 방식과 섞어서는 많이 쓴다.
        if(sessionFactory == null){
            try {
                Properties properties = new Properties();
                properties.load(new FileReader(("src/main/resources/javaconfig/javaconfig.properties")));
                String driver = properties.getProperty("Driver");
                String url = properties.getProperty("URL");
                String user = properties.getProperty("USER");
                String pass = properties.getProperty("PASS");

                Environment environment = new Environment("dev",
                        new JdbcTransactionFactory(),
                        new PooledDataSource(driver, url, user, pass)
                );
                Configuration configuration = new Configuration(environment);
                configuration.addMapper(JavaMenuDAO.class);

                sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return sessionFactory.openSession(false);
    }

    public static SqlSession getRemixSession(){ // Section03 리믹스 설정(위의 2개를 섞음)
        // 자바 설정은 잘 쓰는 방식은 아니다. 단, xml 방식과 섞어서는 많이 쓴다.
        if(sessionFactory == null){
            try {
                Properties properties = new Properties();
                properties.load(new FileReader(("src/main/resources/javaconfig/javaconfig.properties")));
                String driver = properties.getProperty("Driver");
                String url = properties.getProperty("URL");
                String user = properties.getProperty("USER");
                String pass = properties.getProperty("PASS");

                Environment environment = new Environment("dev",
                        new JdbcTransactionFactory(),
                        new PooledDataSource(driver, url, user, pass)
                );
                Configuration configuration = new Configuration(environment);
                configuration.addMapper(RemixMenuDAO.class);

                sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return sessionFactory.openSession(false);
    }
}
