package ch.iet_gibb.application;

public class CylinderTank{
    float diameter;
    float height;
    String name;
    float maxTemp;
    float dailyEnergy;
    float capacity;
    float volume;

    public CylinderTank(float diameter, float height, String name, float maxTemp, float dailyEnergy, float capacity, float volume) {
        this.diameter = diameter;
        this.height = height;
        this.name = name;
        this.maxTemp = maxTemp;
        this.dailyEnergy = dailyEnergy;
        this.capacity = capacity;
        this.volume = calculateRoundTankVolumeInLiters();
    }

    public int calculateRoundTankVolumeInLiters() {
        double radius = diameter / 2;
        double volumeInCubicMeters = Math.PI * radius * radius * height / 1000; // Volumen in Kubikmetern
        return (int) (volumeInCubicMeters * 1000); // Umwandlung in Liter
    }

    public int savedEnergy() {
        return (int) (volume * 4.18 * (maxTemp - 23) / (double) 3600);
    }

    public int numberOfDays() {
        int energy = savedEnergy();
        return energy / (int) dailyEnergy;
    }
}
