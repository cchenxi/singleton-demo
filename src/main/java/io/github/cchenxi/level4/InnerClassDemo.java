package io.github.cchenxi.level4;

/**
 * Date: 2021-10-04
 *
 * @author chenxi
 */
public class InnerClassDemo {
    private static class InnerClass {
        static {
            System.out.println("inner");
        }
    }

    public static void main(String[] args) {
        InnerClassDemo demo = new InnerClassDemo();
    }
}
