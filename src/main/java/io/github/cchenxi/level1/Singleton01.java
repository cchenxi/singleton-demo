package io.github.cchenxi.level1;

/**
 * 单例，饿汉式
 * Date: 2021-10-02
 *
 * @author chenxi
 */
public class Singleton01 {

    private static Singleton01 singleton;

    static {
        singleton = new Singleton01();
    }

    private Singleton01(){}

    public static Singleton01 getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        Singleton01 singleton = Singleton01.getInstance();
    }
}

