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
        // Setzen der Werte über die Setter-Methoden, um Validierungen durchzuführen
        setDiameter(diameter);
        setHeight(height);
        setName(name);
        setMaxTemp(maxTemp);
        setDailyEnergy(dailyEnergy);
        setCapacity(capacity);
        this.volume = calculateRoundTankVolumeInLiters();
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

    /**
     * Gibt den Durchmesser des Zylinders zurück.
     *
     * @return Durchmesser des Zylinders
     */
    public float getDiameter() {
        return diameter;
    }

    /**
     * Setzt den Durchmesser des Zylinders.
     *
     * @param diameter Durchmesser des Zylinders
     * @throws IllegalArgumentException wenn der Durchmesser kleiner oder gleich null ist
     */
    public void setDiameter(float diameter) {
        if (diameter <= 0) {
            throw new IllegalArgumentException("Der Durchmesser muss größer als 0 sein");
        }
        this.diameter = diameter;
    }

    /**
     * Gibt die Höhe des Zylinders zurück.
     *
     * @return Höhe des Zylinders
     */
    public float getHeight() {
        return height;
    }

    /**
     * Setzt die Höhe des Zylinders.
     *
     * @param height Höhe des Zylinders
     * @throws IllegalArgumentException wenn die Höhe kleiner oder gleich null ist
     */
    public void setHeight(float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Die Höhe muss größer als 0 sein");
        }
        this.height = height;
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
