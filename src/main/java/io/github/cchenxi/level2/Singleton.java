package io.github.cchenxi.level2;

/**
 * 单例，懒汉式
 * 线程不安全
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
