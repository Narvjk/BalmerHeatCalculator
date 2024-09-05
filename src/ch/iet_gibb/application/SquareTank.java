package ch.iet_gibb.application;

/**
 * Repräsentiert einen quadratischen Tank mit Höhe, Breite und Länge.
 */
public class SquareTank {
    float height;      // Höhe des Tanks
    float width;       // Breite des Tanks
    float length;      // Länge des Tanks
    String name;       // Name des Tanks
    float maxTemp;     // Maximale Temperatur
    float dailyEnergy; // Täglicher Energieverbrauch
    float capacity;    // Fassungsvermögen des Tanks
    float volume;      // Volumen der gespeicherten Flüssigkeit

    /**
     * Konstruktor zur Initialisierung des quadratischen Tanks.
     *
     * @param height      Höhe des Tanks
     * @param capacity    Fassungsvermögen des Tanks
     * @param dailyEnergy Täglicher Energieverbrauch
     * @param maxTemp     Maximale Temperatur
     * @param name        Name des Tanks
     * @param length      Länge des Tanks
     * @param width       Breite des Tanks
     */
    public SquareTank(float height, float capacity, float dailyEnergy, float maxTemp, String name, float length, float width) {
        this.height = height;
        this.capacity = capacity;
        this.dailyEnergy = dailyEnergy;
        this.maxTemp = maxTemp;
        this.name = name;
        this.length = length;
        this.width = width;
        this.volume = calculateSquareTankVolumeInLiters();

        // Überprüfen, ob die Temperatur unter 30 liegt
        if (maxTemp < 30) {
            throw new IllegalArgumentException("MaxTemperatur kann nicht unter 30 sein");
        }
        // Überprüfen, ob Attribute leer oder null sind
        if (maxTemp == 0 || name.isEmpty() || dailyEnergy == 0 || length == 0 || width == 0 || height == 0) {
            throw new IllegalArgumentException("Attribute können nicht null / leer sein");
        }
    }

    /**
     * Berechnet das Volumen des quadratischen Tanks in Litern.
     *
     * @return Volumen in Litern
     */
    public int calculateSquareTankVolumeInLiters() {
        return (int) (width * length * height / (double) 1000);
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
        return "Fassungsvermögen: " + calculateSquareTankVolumeInLiters() + "\n" +
                "Gespeicherte Energie: " + savedEnergy() + " kWh\n" +
                "Tage: " + numberOfDays();
    }
}
