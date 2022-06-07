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

    public int updateByClinic(AnimalInfo animalInfo) {
        SqlSession session = factory.openSession();
        AnimalInfoMapper mapper = session.getMapper(AnimalInfoMapper.class);

        int result = mapper.updateByClinic(animalInfo);
        if(result == 1) {
            session.commit();
            return 1;
        }

        session.rollback();
        return 0;
    }

    public int updateLoginDate(AnimalInfo animalInfo) {
        SqlSession session = factory.openSession();
        AnimalInfoMapper mapper = session.getMapper(AnimalInfoMapper.class);

        int result = mapper.updateLoginDate(animalInfo);
        if(result == 1) {
            session.commit();
            return 1;
        }

        session.rollback();
        return 0;
    }

    public int getDate(AnimalInfo animalInfo) {
        SqlSession session = factory.openSession();
        AnimalInfoMapper mapper = session.getMapper(AnimalInfoMapper.class);

        return mapper.getDate(animalInfo);
    }

    public int deleteTama(AnimalInfo animalInfo) {
        SqlSession session = factory.openSession();
        AnimalInfoMapper mapper = session.getMapper(AnimalInfoMapper.class);

        int result = mapper.deleteTama(animalInfo);
        if(result == 1) {
            session.commit();
            return 1;
        }

        session.rollback();
        return 0;
    }

    public int feedByFood(AnimalInfo animalInfo) {
        SqlSession session = factory.openSession();
        AnimalInfoMapper mapper = session.getMapper(AnimalInfoMapper.class);

        int result = mapper.feedByFood(animalInfo);
        if(result == 1) {
            session.commit();
            return 1;
        }
        session.rollback();
        return 0;
    }
}