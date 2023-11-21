package com.ohgiraffers.section02.javaconfig.template;

import com.ohgiraffers.section02.javaconfig.model.JavaMenuDAO;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
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

public class JavaConfigTemplate {

    private static SqlSessionFactory sessionFactory;

    public static SqlSession getJavaSqlSession(){
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
}
