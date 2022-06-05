package net.scit.tama.dao;

/**
 * projectName     :tama
 * fileName        :TamaMapper
 * author          :yuuna
 * since           :2022/06/2
 */


import net.scit.tama.vo.AnimalInfo;

/**
 * Mapper XML의 SQL문 사용 메서드
 */

public interface AnimalInfoMapper {
    // 등록된 타마 정보 가져오기
    AnimalInfo selectAnimalInfo(String playerId);

    // 새로운 타마 등록
    int tamainput(AnimalInfo createAnimal);

    // 산책으로 돈 얻기
    int updateMoneyByWalk(AnimalInfo animalInfo);

    int updateMoneyByClinic(AnimalInfo animalInfo);
}
