package io.github.cchenxi.level2;

/**
 * 单例，懒汉式
 * Date: 2021-10-02
 *
 * @author chenxi
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
