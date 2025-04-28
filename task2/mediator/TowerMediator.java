package mediator;

import aircraft.Aircraft;

public interface TowerMediator { // Interface TowerMedia
    void broadcast(String msg, Aircraft sender); // Function which take message from airplane
    boolean requestRunway(Aircraft a); // Function which get true or false for airplane (for using line)
}
