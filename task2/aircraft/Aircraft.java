package aircraft;

import mediator.TowerMediator;

public abstract class Aircraft {
    protected String id;
    protected int fuelLevel;
    protected boolean emergency = false;
    protected TowerMediator mediator;

    public Aircraft(String id, int fuelLevel, TowerMediator mediator) {
        this.id = id;
        this.fuelLevel = fuelLevel;
        this.mediator = mediator;
    }

    public abstract void receive(String msg);

    public void send(String msg, TowerMediator m) {
        m.broadcast(msg, this);
    }

    public String getId() {
        return id;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void declareEmergency() {
        emergency = true;
    }
}
