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
public class Singleton02 {

    private static Singleton02 singleton;

    private Singleton02() {}

    public static Singleton02 getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                singleton = new Singleton02();
            }
        }
        return singleton;
    }
}

