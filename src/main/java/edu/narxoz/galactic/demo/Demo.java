package edu.narxoz.galactic.demo;

import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.task.DeliveryTask;
import edu.narxoz.galactic.task.Dispatcher;
import edu.narxoz.galactic.task.Result;

public class Demo {
    public static void main(String[] args) {
        Planet saturn = new Planet("Saturn", 10, 0, "h20");
        Planet mars= new Planet("Mars", 100, 0, "O3");
        Cargo cargo=new Cargo(70, "Heavy item");
        LightDrone lD=new LightDrone("LD-2", 35);
        HeavyDrone hD=new HeavyDrone("HD-3", 75);
        DeliveryTask task = new DeliveryTask(saturn, mars, cargo);
        Dispatcher dispatcher=new Dispatcher();

        System.out.println("1. task to LightDrone:");
        Result res1=dispatcher.assigTask(task, lD);
        System.out.println("Result:"+ res1.ok()+"reason:"+res1.reason());
        
        System.out.println("\n 2. task to HeavyDrone:");
        Result res2=dispatcher.assigTask(task, hD);
        System.out.println("Result:"+res2.ok()+ "raeson:"+res2.reason());

        System.out.println("\n 3. estimate delivery time:");
        double time=task.estimateTime();
        System.out.println("estimate time:"+time);

        System.out.println("\n 4. complete task:");
        Result res3=dispatcher.completeTask(task);
        System.out.println("Result:"+res3.ok()+"reason:"+res3.reason());

        System.out.println("\n Finals:");
        System.out.println("Drone"+hD.getStatus());
        System.out.println("task"+ task.getState());
    }
}
