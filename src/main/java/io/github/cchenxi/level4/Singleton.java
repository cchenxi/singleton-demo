package io.github.cchenxi.level4;

/**
 * 单例，静态内部类写法
 * Date: 2021-10-04
 *
 * @author chenxi
 */
public class Singleton {
    private Singleton() {}

    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

