package mediator;

import aircraft.Aircraft;
import java.util.*;

public class ControlTower implements TowerMediator{
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private boolean runwayFree = true;
    private List<Aircraft> allAircrafts = new ArrayList<>();

    public void registerAircraft(Aircraft aircraft) {
        allAircrafts.add(aircraft);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        if (msg.equalsIgnoreCase("MAYDAY")) {
            sender.declareEmergency();
            System.out.println("[TOWER]: EMERGENCY from " + sender.getId() + "! Prioritizing emergency landing.");
            landingQueue.remove(sender);
            landingQueue.add(sender);
            notifyAllAircrafts("Emergency landing in progress. Hold your positions!", sender);
        } else if (msg.equalsIgnoreCase("REQUEST_LANDING")) {
            System.out.println("[TOWER]: " + sender.getId() + " requests landing.");
            landingQueue.offer(sender);
        } else if (msg.equalsIgnoreCase("REQUEST_TAKEOFF")) {
            System.out.println("[TOWER]: " + sender.getId() + " requests takeoff.");
            takeoffQueue.offer(sender);
        } else {
            System.out.println("[TOWER]: Unknown message from " + sender.getId());
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (a.isEmergency()) {
            System.out.println("[TOWER]: " + a.getId() + " cleared for EMERGENCY landing.");
            runwayFree = false;
            return true;
        }
        if (runwayFree) {
            if (!landingQueue.isEmpty() && landingQueue.peek().equals(a)) {
                landingQueue.poll();
                runwayFree = false;
                System.out.println("[TOWER]: " + a.getId() + " cleared for landing.");
                return true;
            } else if (!takeoffQueue.isEmpty() && takeoffQueue.peek().equals(a)) {
                takeoffQueue.poll();
                runwayFree = false;
                System.out.println("[TOWER]: " + a.getId() + " cleared for takeoff.");
                return true;
            }
        }
        return false;
    }

    public void freeRunway() {
        runwayFree = true;
    }

    private void notifyAllAircrafts(String message, Aircraft sender) {
        for (Aircraft a : allAircrafts) {
            if (!a.equals(sender)) {
                a.receive(message);
            }
        }
    }

}
