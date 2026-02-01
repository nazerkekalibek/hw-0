package edu.narxoz.galactic.task;

import edu.narxoz.galactic.bodies.Celestialbody;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;

public class DeliveryTask {
    private Celestialbody origin;
    private Celestialbody destination;
    private Cargo cargo;
    private TaskState state;
    private Drone assignedDrone;
    public DeliveryTask(Celestialbody origin, Celestialbody destination, Cargo cargo){
        this.origin=origin;
        this.destination=destination;
        this.cargo=cargo;
        this.state=TaskState.CREATED;
        this.assignedDrone=null;
    }
    public Celestialbody getOrigin(){
        return origin;
    }
    public Celestialbody getDestination(){
        return destination;
    }
    public Cargo gerCargo(){
        return cargo;
    }
    public TaskState getState(){
        return state;
    }
    public Drone getAssignedDrone(){
        return assignedDrone;
    }
    public double estimateTime(){
        if (assignedDrone==null){
            throw new IllegalStateException("Drone not assigned");
        }
        double speed=assignedDrone.speedKmPerMin();
        if(speed<=0){
            throw new IllegalStateException("Drone speed must positive");
        }
        return origin.distanceTo(destination)/speed;
    }
    void setState(TaskState state){
        this.state=state;
    }
    void setAssignedDrone(Drone drone){
        this.assignedDrone=drone;
    }

    Cargo getCargo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
