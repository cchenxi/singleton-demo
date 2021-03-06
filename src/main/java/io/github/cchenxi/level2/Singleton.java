package io.github.cchenxi.level2;

/**
 * 单例，懒汉式
 * 线程不安全
 * <b>错误写法</b>
 *
 * Date: 2021-10-02
 *
 * @author chenxi
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
