package io.github.cchenxi.level1;

/**
 * 单例，饿汉式
 * Date: 2021-10-02
 *
 * @author chenxi
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

