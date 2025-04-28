package aircraft;

import mediator.TowerMediator;

public class CargoPlane extends Aircraft{
    public CargoPlane(String id, int fuelLevel, TowerMediator mediator) {
        super(id, fuelLevel, mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[CargoPlane " + id + "] received: " + msg);
    }
}
