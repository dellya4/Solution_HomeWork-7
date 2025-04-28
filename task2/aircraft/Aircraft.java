package aircraft;

import mediator.TowerMediator;

public abstract class Aircraft { // Abstract class Aircraft
    protected String id;
    protected int fuelLevel;
    protected boolean emergency;
    protected TowerMediator mediator;

    public Aircraft(String id, int fuelLevel, TowerMediator mediator) { // Constructor for Aircraft. Get ID, fuelLevel and save mediator. Emergency first time is always false
        this.id = id;
        this.fuelLevel = fuelLevel;
        this.mediator = mediator;
        this.emergency = false;
    }

    public abstract void receive(String msg); // Abstract function which take message

    public void send(String msg, TowerMediator m) { // Function for getting message throw mediator
        m.broadcast(msg, this);
    }

    public String getId() { // Function which get ID
        return id;
    }

    public int getFuelLevel() { // Function which get fuelLevel
        return fuelLevel;
    }

    public boolean isEmergency() { // Function which get status of emergency
        return emergency;
    }

    public void declareEmergency() { // Function which save emergency situation
        emergency = true;
    }
}
