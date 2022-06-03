package net.scit.tama.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * projectName     :tama
 * fileName        :MybatisConfig
 * author          :yuuna
 * since           :2022/06/2
 */
public class MybatisConfig {
    private static SqlSessionFactory sqlSessionFactory;

    /*
     스태틱 블록 (생성자와 유사한 기능)
     mybatis-config.xml 을
     SqlSessionFactoryBuilder 로 메모리에 올림
     */
    static {
        String resource = "mybatis-config.xml";

        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
