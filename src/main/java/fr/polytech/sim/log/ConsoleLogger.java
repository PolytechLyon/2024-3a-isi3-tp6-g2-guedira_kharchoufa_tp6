package fr.polytech.sim.log;

/**
 * Console logger.
 */
public class ConsoleLogger extends NamedLogger {

    /**
     * Constructor.
     *
     * @param name  logger name.
     */

    public ConsoleLogger(String name) {
        super(name);
    }

    @Override
    protected void writeLog(String message) {
        System.out.println(message);
    }
}
