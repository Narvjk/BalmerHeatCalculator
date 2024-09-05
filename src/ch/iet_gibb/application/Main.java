package ch.iet_gibb.application;

/**
 * Hauptklasse, um die Funktionalitäten der Tank-, SquareTank- und CylinderTank-Klassen zu testen.
 */
public class Main {
    /**
     * Hauptmethode, die Instanzen von Tank, SquareTank und CylinderTank erstellt
     * und deren Details ausgibt.
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        // Erstellen und Initialisieren von drei verschiedenen Tankarten
        Tank tank = new Tank("Friedrich", 60, 100, 100, 500);
        SquareTank squareTank = new SquareTank(50, 100, 100, 60, "Heindrich", 200, 100);
        CylinderTank cylinderTank = new CylinderTank(100, 50, "Hans", 60, 100, 100);

        // Ausgabe der Tank-Details
        System.out.println(tank);
        System.out.println(squareTank);
        System.out.println(cylinderTank);
    }
}
