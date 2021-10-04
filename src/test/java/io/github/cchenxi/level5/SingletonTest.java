package io.github.cchenxi.level5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test case for {@link Singleton}.
 * Date: 2021-10-04
 *
 * @author chenxi
 */
public class SingletonTest {
    @Test
    public void should_new_single_instance() {
        Enum.valueOf(Singleton.class, "INSTANCE");
        System.out.println(1);

    }
}