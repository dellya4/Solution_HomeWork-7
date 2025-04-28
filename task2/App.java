import aircraft.*;
import mediator.*;

import java.util.*;

public class App {
    private final ControlTower tower;
    private List<Aircraft> aircrafts;

    public App() {
        tower = new ControlTower();
        aircrafts = new ArrayList<>();
    }

    public void start() {
        Aircraft plane1 = new PassengerPlane("P-101", 75, tower);
        Aircraft plane2 = new CargoPlane("C-202", 50, tower);
        Aircraft helicopter = new Helicopter("H-303", 30, tower);

        aircrafts = Arrays.asList(plane1, plane2, helicopter);

        for (Aircraft aircraft : aircrafts) {
            tower.registerAircraft(aircraft);

            if (aircraft instanceof PassengerPlane || aircraft instanceof Helicopter) {
                aircraft.send("REQUEST_LANDING", tower);
            } else {
                aircraft.send("REQUEST_TAKEOFF", tower);
            }
        }

        for (Aircraft aircraft : aircrafts) {
            if (tower.requestRunway(aircraft)) {
                System.out.println("[ACTION]: " + aircraft.getId() + " is using the runway...");
                tower.freeRunway();
            } else {
                System.out.println("[WAIT]: " + aircraft.getId() + " is waiting for runway...");
            }
        }

        System.out.println("\n[SIMULATION]: Helicopter sending MAYDAY...");
        helicopter.send("MAYDAY", tower);

        if (tower.requestRunway(helicopter)) {
            System.out.println("[EMERGENCY LANDING]: " + helicopter.getId() + " is landing immediately!");
        }
    }
}
