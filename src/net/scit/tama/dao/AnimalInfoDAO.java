package net.scit.tama.dao;

import net.scit.tama.vo.AnimalInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * projectName     :tama
 * fileName        :TamaDAO
 * author          :yuuna
 * since           :2022/06/2
 */

public class AnimalInfoDAO {
    private final SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();


    public AnimalInfo selectAnimalInfo(String playerId) {
        SqlSession session = factory.openSession();
        AnimalInfoMapper mapper = session.getMapper(AnimalInfoMapper.class);

        return mapper.selectAnimalInfo(playerId);
    }

    public int tamainput(AnimalInfo createAnimal) {
        SqlSession session = factory.openSession();
        AnimalInfoMapper mapper = session.getMapper(AnimalInfoMapper.class);

        int result = mapper.tamainput(createAnimal);
        if(result == 1) {
            session.commit();
            return 1;
        }

        session.rollback();
        return 0;
    }

    public void updateMoneyByWalk(AnimalInfo animalInfo) {
        SqlSession session = factory.openSession();
        AnimalInfoMapper mapper = session.getMapper(AnimalInfoMapper.class);

        int result = mapper.updateMoneyByWalk(animalInfo);
        if(result == 1) {
            session.commit();
            return;
        }

        session.rollback();
    }
}