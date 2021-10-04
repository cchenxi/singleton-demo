package io.github.cchenxi.level3;

/**
 * 单例，双重检查
 * Date: 2021-10-04
 *
 * @author chenxi
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
