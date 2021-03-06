package io.github.cchenxi.level2;

/**
 * 单例，懒汉式
 *
 * Date: 2021-10-02
 *
 * @author chenxi
 */
public class Singleton01 {
    private static Singleton01 instance;

    private Singleton01() {}

    public static synchronized Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }
}
