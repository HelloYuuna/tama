package net.scit.tama.dao;

import net.scit.tama.vo.Player;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * projectName     :tama
 * fileName        :TamaDAO
 * author          :yuuna
 * since           :2022/06/2
 */

public class PlayerDAO {
    private final SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

    public Player findById(String playerId) {
        SqlSession session = factory.openSession();
        PlayerMapper mapper = session.getMapper(PlayerMapper.class);

        return mapper.findById(playerId);
    }

    public int playerInput(Player player) {
        SqlSession session = factory.openSession();
        PlayerMapper mapper = session.getMapper(PlayerMapper.class);
        int result = mapper.playerInput(player);
        if(result == 1) {
            session.commit();
            return 1;
        }

        session.rollback();
        return 0;
    }

    public Player findByPwd(String playerPwd) {
        SqlSession session = factory.openSession();
        PlayerMapper mapper = session.getMapper(PlayerMapper.class);

        return mapper.findByPwd(playerPwd);
    }
}