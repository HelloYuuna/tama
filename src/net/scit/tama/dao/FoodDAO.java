package net.scit.tama.dao;

import net.scit.tama.vo.AnimalInfo;
import net.scit.tama.vo.Food;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


/**
 * projectName     :tama
 * fileName        :TamaDAO
 * author          :yuuna
 * since           :2022/06/2
 */

public class FoodDAO {
    private final SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

    public List<Food> listFood() {
        SqlSession session = factory.openSession();
        FoodMapper mapper = session.getMapper(FoodMapper.class);

        return mapper.listFood();
    }
}