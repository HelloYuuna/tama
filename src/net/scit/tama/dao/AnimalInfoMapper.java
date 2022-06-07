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

    // 병원비용 차감
    int updateByClinic(AnimalInfo animalInfo);

    // 로그타임 업데이트
    int updateLoginDate(AnimalInfo animalInfo);

    // 시스템데이트 - 로그인데이트
    int getDate(AnimalInfo animalInfo);

    // 무지개별로 간 타마 삭제
    int deleteTama(AnimalInfo animalInfo);

    // 돈주고 먹을거 사기
    int feedByFood(AnimalInfo animalInfo);
}
