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
        // Setzen der Werte über die Setter-Methoden, um Validierungen durchzuführen
        setHeight(height);
        setCapacity(capacity);
        setDailyEnergy(dailyEnergy);
        setMaxTemp(maxTemp);
        setName(name);
        setLength(length);
        setWidth(width);
        this.volume = calculateSquareTankVolumeInLiters();
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

    /**
     * Gibt die Höhe des Tanks zurück.
     *
     * @return Höhe des Tanks
     */
    public float getHeight() {
        return height;
    }

    /**
     * Setzt die Höhe des Tanks.
     *
     * @param height Höhe des Tanks
     * @throws IllegalArgumentException wenn die Höhe kleiner oder gleich null ist
     */
    public void setHeight(float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Die Höhe muss größer als 0 sein");
        }
        this.height = height;
    }

    /**
     * Gibt die Breite des Tanks zurück.
     *
     * @return Breite des Tanks
     */
    public float getWidth() {
        return width;
    }

    /**
     * Setzt die Breite des Tanks.
     *
     * @param width Breite des Tanks
     * @throws IllegalArgumentException wenn die Breite kleiner oder gleich null ist
     */
    public void setWidth(float width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Die Breite muss größer als 0 sein");
        }
        this.width = width;
    }

    /**
     * Gibt die Länge des Tanks zurück.
     *
     * @return Länge des Tanks
     */
    public float getLength() {
        return length;
    }

    /**
     * Setzt die Länge des Tanks.
     *
     * @param length Länge des Tanks
     * @throws IllegalArgumentException wenn die Länge kleiner oder gleich null ist
     */
    public void setLength(float length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Die Länge muss größer als 0 sein");
        }
        this.length = length;
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
            throw new IllegalArgumentException("Der Name darf nicht leer oder null sein");
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
            throw new IllegalArgumentException("Die maximale Temperatur darf nicht unter 30°C liegen");
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
            throw new IllegalArgumentException("Der tägliche Energieverbrauch muss größer als 0 sein");
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
            throw new IllegalArgumentException("Das Fassungsvermögen muss größer als 0 sein");
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
     */
    public void setVolume(float volume) {
        this.volume = volume;
    }
}
