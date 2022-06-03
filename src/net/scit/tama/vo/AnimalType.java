package net.scit.tama.vo;

/**
 * projectName     :tama
 * fileName        :Type
 * author          :yuuna
 * since           :2022/06/02
 */
public class AnimalType {
    private int typeSeq;
    private int lifespan;
    private String species;

    public AnimalType() {
    }

    public AnimalType(int typeSeq, int lifespan, String species) {
        this.typeSeq = typeSeq;
        this.lifespan = lifespan;
        this.species = species;
    }

    public int getTypeSeq() {
        return typeSeq;
    }

    public void setTypeSeq(int typeSeq) {
        this.typeSeq = typeSeq;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "AnimalType{" +
                "typeSeq=" + typeSeq +
                ", lifespan=" + lifespan +
                ", species='" + species + '\'' +
                '}';
    }
}
