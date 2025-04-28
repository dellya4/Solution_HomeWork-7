package mediator;

import aircraft.Aircraft;
import java.util.*;

public class ControlTower implements TowerMediator{ // Class ControlTower which mission control
    private Queue<Aircraft> landingQueue = new LinkedList<>(); // Queue for landing
    private Queue<Aircraft> takeoffQueue = new LinkedList<>(); // Queue for taking off
    private boolean runwayFree = true; // Save status of line
    private List<Aircraft> allAircrafts = new ArrayList<>(); // Array for saving airplane

    public void registerAircraft(Aircraft aircraft) { // Function which airplane to array
        allAircrafts.add(aircraft);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) { // Function which check message from airplane
        if (msg.equalsIgnoreCase("MAYDAY")) { // When airplane have emergency
            sender.declareEmergency();
            System.out.println("[TOWER]: EMERGENCY from " + sender.getId() + "! Prioritizing emergency landing.");
            landingQueue.remove(sender);
            landingQueue.add(sender);
            notifyAllAircrafts("Emergency landing in progress. Hold your positions!", sender);
        } else if (msg.equalsIgnoreCase("REQUEST_LANDING")) { // When airplane want taking off
            System.out.println("[TOWER]: " + sender.getId() + " requests landing.");
            landingQueue.offer(sender);
        } else if (msg.equalsIgnoreCase("REQUEST_TAKEOFF")) { // When airplane want landing
            System.out.println("[TOWER]: " + sender.getId() + " requests takeoff.");
            takeoffQueue.offer(sender);
        } else { // If airplane get unknowing message
            System.out.println("[TOWER]: Unknown message from " + sender.getId());
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) { // Function which get permission to use line
        if (a.isEmergency()) { // Check if airplane not have emergency status and get permission
            System.out.println("[TOWER]: " + a.getId() + " cleared for EMERGENCY landing.");
            runwayFree = false;
            return true;
        }
        if (runwayFree) { // Check if line is free
            if (!landingQueue.isEmpty() && landingQueue.peek().equals(a)) { // If airplane in first place in queue, get permission to take off
                landingQueue.poll();
                runwayFree = false;
                System.out.println("[TOWER]: " + a.getId() + " cleared for landing.");
                return true;
            } else if (!takeoffQueue.isEmpty() && takeoffQueue.peek().equals(a)) { // If airplane in first place in queue, get permission to land
                takeoffQueue.poll();
                runwayFree = false;
                System.out.println("[TOWER]: " + a.getId() + " cleared for takeoff.");
                return true;
            }
        }
        return false; // Return false if line is busy or if airplane is not first in queue
    }

    public void freeRunway() { // Function which make line empty
        runwayFree = true;
    }

    private void notifyAllAircrafts(String message, Aircraft sender) { // Function which send message all airplanes except airplane which send message
        for (Aircraft a : allAircrafts) {
            if (!a.equals(sender)) {
                a.receive(message);
            }
        }
    }

}
