package ch.iet_gibb.application;

public class SquareTank{
    float height;
    float width;
    float length;
    String name;
    float maxTemp;
    float dailyEnergy;
    float capacity;
    float volume;

    public SquareTank(float height, float volume, float capacity, float dailyEnergy, float maxTemp, String name, float length, float width) {
        this.height = height;
        this.volume = volume;
        this.capacity = capacity;
        this.dailyEnergy = dailyEnergy;
        this.maxTemp = maxTemp;
        this.name = name;
        this.length = length;
        this.width = width;
        this.volume = calculateSquareTankVolumeInLiters();

    }

    public int calculateSquareTankVolumeInLiters() {
        return (int) (width * width * height / (double) 1000);
    }

    public int savedEnergy() {
        return (int) (volume * 4.18 * (maxTemp - 23) / (double) 3600);
    }

    public int numberOfDays() {
        int energy = savedEnergy();
        return energy / (int) dailyEnergy;
    }
}

