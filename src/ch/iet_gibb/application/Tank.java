package ch.iet_gibb.application;

public class Tank {
    String name;
    float maxTemp;
    float dailyEnergy;
    float capacity;
    float volume;

    public Tank(String name, float maxTemp, float dailyEnergy, float capacity, float volume) {
        this.name = name;
        this.maxTemp = maxTemp;
        this.dailyEnergy = dailyEnergy;
        this.capacity = capacity;
        this.volume = volume;
    }

    public int savedEnergy() {
        return (int) (volume * 4.18 * (maxTemp - 23) / (double) 3600);
    }

    public int numberOfDays() {
        int energy = savedEnergy();
        return energy / (int) dailyEnergy;
    }

    @Override
    public String toString() {

    }
}
