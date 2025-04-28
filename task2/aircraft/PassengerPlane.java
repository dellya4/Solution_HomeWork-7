package aircraft;

import mediator.TowerMediator;

public class PassengerPlane extends Aircraft{
    public PassengerPlane(String id, int fuelLevel, TowerMediator mediator){
        super(id, fuelLevel, mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[PassengerPlane " + id + "] received: " + msg);
    }
}
