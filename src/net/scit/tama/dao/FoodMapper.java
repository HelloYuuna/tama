package net.scit.tama.dao;

/**
 * projectName     :tama
 * fileName        :TamaMapper
 * author          :yuuna
 * since           :2022/06/2
 */


import net.scit.tama.vo.Food;
import java.util.List;

/**
 * Mapper XML의 SQL문 사용 메서드
 */

public interface FoodMapper {
        List<Food> listFood();
}
