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
        // Initialisierung der Attribute über Setter-Methoden, um Validierung sicherzustellen
        setName(name);
        setMaxTemp(maxTemp);
        setDailyEnergy(dailyEnergy);
        setCapacity(capacity);
        setVolume(volume);
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

    /**
     * Gibt den Namen des Tanks zurück.
     *
     * @return Name des Tanks
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen des Tanks.
     *
     * @param name Name des Tanks
     * @throws IllegalArgumentException wenn der Name leer oder null ist
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht leer oder null sein");
        }
        this.name = name;
    }

    /**
     * Gibt die maximale Temperatur im Tank zurück.
     *
     * @return Maximale Temperatur im Tank
     */
    public float getMaxTemp() {
        return maxTemp;
    }

    /**
     * Setzt die maximale Temperatur des Tanks.
     *
     * @param maxTemp Maximale Temperatur im Tank
     * @throws IllegalArgumentException wenn die Temperatur unter 30 Grad liegt
     */
    public void setMaxTemp(float maxTemp) {
        if (maxTemp < 30) {
            throw new IllegalArgumentException("MaxTemperatur kann nicht unter 30 sein");
        }
        this.maxTemp = maxTemp;
    }

    /**
     * Gibt den täglichen Energieverbrauch des Tanks zurück.
     *
     * @return Täglicher Energieverbrauch in kWh
     */
    public float getDailyEnergy() {
        return dailyEnergy;
    }

    /**
     * Setzt den täglichen Energieverbrauch des Tanks.
     *
     * @param dailyEnergy Täglicher Energieverbrauch
     * @throws IllegalArgumentException wenn der tägliche Energieverbrauch kleiner oder gleich null ist
     */
    public void setDailyEnergy(float dailyEnergy) {
        if (dailyEnergy <= 0) {
            throw new IllegalArgumentException("Täglicher Energieverbrauch muss größer als 0 sein");
        }
        this.dailyEnergy = dailyEnergy;
    }

    /**
     * Gibt das Fassungsvermögen des Tanks zurück.
     *
     * @return Fassungsvermögen des Tanks
     */
    public float getCapacity() {
        return capacity;
    }

    /**
     * Setzt das Fassungsvermögen des Tanks.
     *
     * @param capacity Fassungsvermögen des Tanks
     * @throws IllegalArgumentException wenn das Fassungsvermögen kleiner oder gleich null ist
     */
    public void setCapacity(float capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Fassungsvermögen muss größer als 0 sein");
        }
        this.capacity = capacity;
    }

    /**
     * Gibt das Volumen der gespeicherten Flüssigkeit im Tank zurück.
     *
     * @return Volumen der gespeicherten Flüssigkeit
     */
    public float getVolume() {
        return volume;
    }

    /**
     * Setzt das Volumen der gespeicherten Flüssigkeit im Tank.
     *
     * @param volume Volumen der gespeicherten Flüssigkeit
     * @throws IllegalArgumentException wenn das Volumen kleiner oder gleich null ist
     */
    public void setVolume(float volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("Volumen muss größer als 0 sein");
        }
        this.volume = volume;
    }
}
