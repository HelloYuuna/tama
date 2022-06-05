package net.scit.tama.vo;

/**
 * projectName     :tama
 * fileName        :AnimalInfo
 * author          :yuuna
 * since           :2022/06/02
 */
public class AnimalInfo {
    private int animalSeq;
    private int typeSeq;
    private String playerId;
    private String birth;
    private String animalName;
    private String condition;
    private int money;
    private String logindate;

    public AnimalInfo() {
    }

//    public AnimalInfo(int animalSeq, int typeSeq, String playerId, String birth, String animalName, String condition, int money, String logindate) {
//        this.animalSeq = animalSeq;
//        this.typeSeq = typeSeq;
//        this.playerId = playerId;
//        this.birth = birth;
//        this.animalName = animalName;
//        this.condition = condition;
//        this.money = money;
//        this.logindate = logindate;
//    }

    public int getAnimalSeq() {
        return animalSeq;
    }

    public void setAnimalSeq(int animalSeq) {
        this.animalSeq = animalSeq;
    }

    public int getTypeSeq() {
        return typeSeq;
    }

    public void setTypeSeq(int typeSeq) {
        this.typeSeq = typeSeq;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }

    @Override
    public String toString() {
        return String.format("%s - 생일:%s, 상태:%s, 소지금:%,d원", animalName, birth, condition, money);
    }
}
