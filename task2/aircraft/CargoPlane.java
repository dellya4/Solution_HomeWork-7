package aircraft;

import mediator.TowerMediator;

public class CargoPlane extends Aircraft{ // Class CargoPlane
    public CargoPlane(String id, int fuelLevel, TowerMediator mediator) { // Constructor CargoPlane
        super(id, fuelLevel, mediator);
    }

    @Override
    public void receive(String msg) { // Function which send reaction to message
        System.out.println("[CargoPlane " + id + "] received: " + msg);
    }
}
