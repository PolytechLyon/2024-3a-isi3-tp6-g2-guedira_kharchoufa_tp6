package fr.polytech.sim.log;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampedLoggerDecorator implements Logger {
    private final Logger logger;

    public TimestampedLoggerDecorator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String format, Object... args) {
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.logger.log(String.format("%s : %s", formattedDateTime, String.format(format, args)));
    }
}