package net.scit.tama.dao;

/**
 * projectName     :tama
 * fileName        :TamaMapper
 * author          :yuuna
 * since           :2022/06/2
 */


import net.scit.tama.vo.Player;

public interface PlayerMapper {
    // 회원등록
    public int playerInput(Player player);

    // 아이디확인
    public Player findById(String playerId);

    // 비밀번호확인
    Player findByPwd(String playerPwd);
}
