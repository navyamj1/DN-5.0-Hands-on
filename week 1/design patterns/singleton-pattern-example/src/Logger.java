// singleton pattern

public class Logger {

    private static Logger instance;

    //Private constructor
    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) {
            Logger obj = new Logger();
            instance = obj;
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]   " + message);
    }

    public void warn(String message) {
        System.out.println("[WARN]  " + message);
    }

    public void error(String message) {
        System.out.println("[ERROR] " + message);
    }
}
