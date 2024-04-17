package fr.polytech.sim;

import java.util.Random;

/**
 * A clock used to synchronize simulations.
 */
public class Clock {
    private static volatile Clock instance;
    private final int time;

    private Clock() {
        this.time = new Random().nextInt(25);
    }

    public static Clock getInstance() {
        if (instance == null) {
            synchronized (Clock.class) {
                if (instance == null) {
                    instance = new Clock();
                }
            }
        }
        return instance;}
    /**
     * Random integer between 0 and 24 inclusive.
     */
    public int getTime() {
        return this.time;
    }
}
