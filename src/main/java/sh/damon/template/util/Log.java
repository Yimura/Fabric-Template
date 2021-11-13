package sh.damon.template.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private String modName;

    private Logger logger = LogManager.getLogger(this);

    public Log(String modName) {
        this.modName = modName;
    }

    public void trace(String message) {
        this.log(Level.TRACE, message);
    }

    public void debug(String message) {
        this.log(Level.DEBUG, message);
    }

    public void info(String message) {
        this.log(Level.INFO, message);
    }

    public void warn(String message) {
        this.log(Level.WARN, message);
    }

    public void error(String message) {
        this.log(Level.ERROR, message);
    }

    public void fatal(String message) {
        this.log(Level.FATAL, message);
    }

    private void log(Level level, String message) {
        logger.log(level, String.format("[%s] %s", this.modName, message));
    }
}
