package fr.polytech.sim.cycling;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.log.LoggerFactory;
import fr.polytech.sim.utils.Context;
import java.util.Iterator;


/**
 * Bike simulation.
 */
public class BikeSimulator implements Simulation {
    private final Logger logger;

    public BikeSimulator() {
        this.logger = LoggerFactory.getLogger("BikeSimulator");
    }


    public void run() {
        // Simulation d'un vélo simple
        System.out.println("\n Simulation d'un vélo simple :");
        Bike bike = new SimpleBike();
        this.logger.log("Bike's speed %.2f Km/h.", bike.getVelocity());
        this.logger.log("Bike's mass %.2f Kg.", bike.getMass());

        // Simulation d'un vélo avec injection de dépendance
        System.out.println("\n Simulation d'un vélo avec injection de dépendance :");
        Bike injection = Context.inject(Bike.class);
        this.logger.log("Injected bike (Type: %s) speed: %.2f Km/h", injection.getClass().getSimpleName(), injection.getVelocity());
        this.logger.log("Injected bike (Type: %s) mass: %.2f Kg", injection.getClass().getSimpleName(), injection.getMass());

        // Simulation de tous les vélos disponibles
        System.out.println("\n Simulation de tous les vélos disponibles par itération :");
        Iterator<Bike> bikeIterator = Context.injectAll(Bike.class);
        while (bikeIterator.hasNext()) {
            Bike bike1 = bikeIterator.next();
            this.logger.log("Bike's speed %.2f Km/h.", bike1.getVelocity());
            this.logger.log("Bike's mass %.2f Kg.", bike1.getMass());
        }
    }
}
