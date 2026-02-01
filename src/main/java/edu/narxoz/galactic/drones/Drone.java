package edu.narxoz.galactic.drones;

public abstract class Drone {
    private String id;
    private DroneStatus status;
    private double maxPayloadKg;
    protected Drone(String id, double maxPayloadKg){
        if (maxPayloadKg<=0){
            throw new IllegalArgumentException("max pay must greater more than 0");
        }
        this.id=id;
        this.maxPayloadKg=maxPayloadKg;
        this.status=status;
    }
    public String getId(){
        return id;
    }
    public DroneStatus getStatus(){
        return status;
    }
    public void setStatus(DroneStatus status){
        this.status=status;
    }
    public double getMaxPayloadKg(){
        return maxPayloadKg;
    }
    public abstract double speedKmPerMin();
}
