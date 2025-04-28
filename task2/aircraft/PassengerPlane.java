package aircraft;

import mediator.TowerMediator;

public class PassengerPlane extends Aircraft{ // Class Passenger Plane
    public PassengerPlane(String id, int fuelLevel, TowerMediator mediator){ // Constructor Airplane
        super(id, fuelLevel, mediator);
    }

    @Override
    public void receive(String msg) { // Function which send reaction to message
        System.out.println("[PassengerPlane " + id + "] received: " + msg);
    }
}
