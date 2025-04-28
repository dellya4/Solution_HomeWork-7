package aircraft;

import mediator.TowerMediator;

public class Helicopter extends Aircraft{ // Class Helicopter
    public Helicopter(String id, int fuelLevel, TowerMediator mediator) { // Constructor Helicopter
        super(id, fuelLevel, mediator);
    }

    @Override
    public void receive(String msg) { // Function which send reaction to message
        System.out.println("[Helicopter " + id + "] received: " + msg);
    }
}
