

public class LoggerTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("logger1: " + logger1);
        System.out.println("logger2: " + logger2);
        System.out.println();

        System.out.println("singleton test\n");

        if (logger1 == logger2) {
            System.out.println("Both variables point to the same instance.Passed!");
            System.out.println("hashcode: " + logger1.hashCode());
        } else {
            System.out.println("Different Logger objects.Failed!");
        }

        System.out.println("\nsample output:");
        logger1.log("Application started");
        logger1.warn("Config not found using defaults");
        logger2.error("Database timeout!");
        logger2.log("Retry succeeded");
    }
}
