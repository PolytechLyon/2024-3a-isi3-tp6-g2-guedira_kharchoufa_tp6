package fr.polytech.sim.log;

/**
 * Name logger that is supposed to log its name along with each log entry, to
 * facilitate tracing.
 */
public abstract class NamedLogger implements Logger {
    final protected String name;

    /**
     * Constructor.
     *
     * @param name  logger name.
     */
    protected NamedLogger(String name) {
        this.name = name;
    }

    protected abstract void writeLog(String message);

    @Override
    public void log(String format, Object... args) {
        String entry = String.format(format, args);
        String message = String.format("%s\n%s", this.name, entry);
        writeLog(message);
    }
}
