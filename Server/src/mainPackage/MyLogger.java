package mainPackage;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class MyLogger {
    private static Logger logger = LoggerFactory.getLogger("my logger");

    public static Logger getLogger() {
        return logger;
    }

    public static void info(String s) {
        logger.info(s);
    }

    public static void error(String s) {
        logger.error(s);
    }
}
