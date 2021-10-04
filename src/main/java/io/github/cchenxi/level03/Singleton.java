package io.github.cchenxi.level03;

/**
 * 单例，双重检查
 * Date: 2021-10-04
 *
 * @author chenxi
 */
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {
        System.out.println("init");
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
