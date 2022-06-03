package net.scit.tama.vo;

/**
 * projectName     :tama
 * fileName        :Food
 * author          :yuuna
 * since           :2022/06/02
 */
public class Food {
    private int foodSeq;
    private int typeSeq;
    private String foodName;
    private int price;

    public Food() {
    }

    public Food(int foodSeq, int typeSeq, String foodName, int price) {
        this.foodSeq = foodSeq;
        this.typeSeq = typeSeq;
        this.foodName = foodName;
        this.price = price;
    }

    public int getFoodSeq() {
        return foodSeq;
    }

    public void setFoodSeq(int foodSeq) {
        this.foodSeq = foodSeq;
    }

    public int getTypeSeq() {
        return typeSeq;
    }

    public void setTypeSeq(int typeSeq) {
        this.typeSeq = typeSeq;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodSeq=" + foodSeq +
                ", typeSeq=" + typeSeq +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                '}';
    }
}
