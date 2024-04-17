package fr.polytech.sim.transport;

import fr.polytech.sim.log.Logger;
import java.util.Iterator;
import fr.polytech.sim.log.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Vehicle abstraction.
 */
public abstract class Vehicle implements MobileObject {

    private final Logger logger;
    protected final List<MobileObject> components = new ArrayList<>();

    public Vehicle() {
        this.logger = LoggerFactory.getLogger("VehicleLogger");
    }

    /**
     * Force applied to push the vehicle.
     *
     * @return  push force.
     */
    public abstract double getPush();

    /**
     * Calculate and return vehicle's velocity based on individual velocities of
     * its components.
     *
     * @return vehicle speed
     */
    @Override
    public double getVelocity() {
        Iterator<MobileObject> iterator = components.iterator();
        double sumPonderedVelocities = 0;
        double sumMass = 0;
        while (iterator.hasNext()) {
            MobileObject item = iterator.next();
            sumPonderedVelocities += item.getVelocity() * item.getMass();
            sumMass += item.getMass();
        }
        double velocity = sumPonderedVelocities == 0 ? 0 :
                sumPonderedVelocities / sumMass;
        this.logger.log("Velocity %.2f Km/h.", velocity);
        return velocity;
    }

    /**
     * Calculate and return vehicle's mass as the sum of individual masses of
     * its components.
     *
     * @return vehicle mass
     */
    @Override
    public double getMass() {
        return this.components.stream()
                .mapToDouble(MobileObject::getMass)
                .sum();
    }
}
