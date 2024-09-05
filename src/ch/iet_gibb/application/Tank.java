package ch.iet_gibb.application;

/**
 * Repräsentiert einen allgemeinen Tank, der Flüssigkeit speichert und Energie berechnet.
 */
public class Tank {
    String name;      // Name des Tanks
    float maxTemp;    // Maximale Temperatur im Tank
    float dailyEnergy;// Täglicher Energieverbrauch in kWh
    float capacity;   // Fassungsvermögen des Tanks
    float volume;     // Volumen der gespeicherten Flüssigkeit

    /**
     * Konstruktor zur Initialisierung der Tankattribute.
     *
     * @param name        Name des Tanks
     * @param maxTemp     Maximale Temperatur im Tank
     * @param dailyEnergy Täglicher Energieverbrauch
     * @param capacity    Fassungsvermögen des Tanks
     * @param volume      Volumen der gespeicherten Flüssigkeit
     */
    public Tank(String name, float maxTemp, float dailyEnergy, float capacity, float volume) {
        this.name = name;
        this.maxTemp = maxTemp;
        this.dailyEnergy = dailyEnergy;
        this.capacity = capacity;
        this.volume = volume;

        // Überprüfen, ob die Temperatur unter 30 liegt
        if (maxTemp < 30) {
            throw new IllegalArgumentException("MaxTemperatur kann nicht unter 30 sein");
        }
        // Überprüfen, ob Attribute leer oder null sind
        if (maxTemp == 0 || name.isEmpty() || volume == 0 || dailyEnergy == 0) {
            throw new IllegalArgumentException("Attribute können nicht null / leer sein");
        }
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
        return "Fassungsvermögen: " + volume + "\n" +
                "Gespeicherte Energie: " + savedEnergy() + " kWh\n" +
                "Tage: " + numberOfDays();
    }
}
