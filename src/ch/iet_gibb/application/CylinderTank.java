package ch.iet_gibb.application;

/**
 * Repräsentiert einen zylindrischen Tank mit Durchmesser und Höhe.
 */
public class CylinderTank {
    float diameter;    // Durchmesser des Zylinders
    float height;      // Höhe des Zylinders
    String name;       // Name des Tanks
    float maxTemp;     // Maximale Temperatur
    float dailyEnergy; // Täglicher Energieverbrauch
    float capacity;    // Fassungsvermögen des Tanks
    float volume;      // Volumen der gespeicherten Flüssigkeit

    /**
     * Konstruktor zur Initialisierung des zylindrischen Tanks.
     *
     * @param diameter    Durchmesser des Zylinders
     * @param height      Höhe des Zylinders
     * @param name        Name des Tanks
     * @param maxTemp     Maximale Temperatur
     * @param dailyEnergy Täglicher Energieverbrauch
     * @param capacity    Fassungsvermögen des Tanks
     */
    public CylinderTank(float diameter, float height, String name, float maxTemp, float dailyEnergy, float capacity) {
        this.diameter = diameter;
        this.height = height;
        this.name = name;
        this.maxTemp = maxTemp;
        this.dailyEnergy = dailyEnergy;
        this.capacity = capacity;
        this.volume = calculateRoundTankVolumeInLiters();

        // Überprüfen, ob die Temperatur unter 30 liegt
        if (maxTemp < 30) {
            throw new IllegalArgumentException("MaxTemperatur kann nicht unter 30 sein");
        }
        // Überprüfen, ob Attribute leer oder null sind
        if (maxTemp == 0 || name.isEmpty() || dailyEnergy == 0 || diameter == 0 || height == 0) {
            throw new IllegalArgumentException("Attribute können nicht null / leer sein");
        }
    }

    /**
     * Berechnet das Volumen des zylindrischen Tanks in Litern.
     *
     * @return Volumen in Litern
     */
    public int calculateRoundTankVolumeInLiters() {
        double radius = diameter / 2;
        double volumeInCubicMeters = Math.PI * radius * radius * height / 1000;
        return (int) (volumeInCubicMeters * 1000);
    }

    /**
     * Berechnet die im Tank gespeicherte Energie in kWh.
     *
     * @return die gespeicherte Energie in kWh
     */
    public int savedEnergy() {
        return (int) (volume * 4.18 * (maxTemp - 23) / (double) 3600);
    }

    /**
     * Berechnet die Anzahl der Tage, für die die gespeicherte Energie ausreicht.
     *
     * @return Anzahl der Tage
     */
    public int numberOfDays() {
        int energy = savedEnergy();
        return energy / (int) dailyEnergy;
    }

    /**
     * Gibt eine String-Darstellung des Tanks zurück, inklusive Volumen, gespeicherter Energie und Anzahl der Tage.
     *
     * @return String-Darstellung der Tank-Details
     */
    @Override
    public String toString() {
        return "Fassungsvermögen: " + calculateRoundTankVolumeInLiters() + "\n" +
                "Gespeicherte Energie: " + savedEnergy() + " kWh\n" +
                "Tage: " + numberOfDays();
    }
}
