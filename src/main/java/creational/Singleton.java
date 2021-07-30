package creational;

import java.io.Serializable;

/**
 * Use When
 * - Exactly one instance of a class is required.
 * - Controlled access to a single object is necessary.
 *
 * @author Ima Miri <ima.miri11@gmail.com>
 */
public class Singleton implements Serializable{

    private static Singleton instance = null;
    private StringBuffer log;

    private Singleton(){
        log = new StringBuffer();
    }

    public static Singleton getInstance(){
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }

    public StringBuffer getLog() {
        return log;
    }

    public void addLog(String log) {
        this.log.append(log).append("\n");
    }

    /**
     * Must be implemented when the class implement Serializable
     * @return An object of Singleton class
     */
    protected Singleton readResolve() {
        return getInstance();
    }
}
