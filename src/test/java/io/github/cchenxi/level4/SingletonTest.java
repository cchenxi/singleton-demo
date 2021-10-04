package io.github.cchenxi.level4;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * Test case for {@link Singleton}.
 * Date: 2021-10-04
 *
 * @author chenxi
 */
public class SingletonTest {
    @SneakyThrows
    @Test
    public void should_new_single_instance() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future[] futures = new Future[2];
        for (int i = 0; i < 2; i++) {
            Future future = executorService.submit(new SingletonTest.Task(cyclicBarrier));
            futures[i] = future;
        }

        Object o1 = futures[0].get();
        Object o2 = futures[1].get();
        System.out.println("object 1 = " + o1);
        System.out.println("object 2 = " + o2);

        boolean instanceEquals = Objects.equals(o1, o2);
        Assert.assertTrue(instanceEquals);
    }

    static class Task implements Callable {
        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @SneakyThrows
        @Override
        public Object call() throws Exception {
            System.out.printf("%s 正在等待\n", Thread.currentThread().getName());
            // 模拟，等待所有线程都到达
            cyclicBarrier.await();
            return Singleton.getInstance();
        }
    }

    @SneakyThrows
    @Test
    public void should_new_multi_instance() {
        ObjectMapper objectMapper = new ObjectMapper();
        Singleton o1 = objectMapper.readValue("{}", Singleton.class);
        Singleton o2 = objectMapper.readValue("{}", Singleton.class);
        System.out.println("object 1 = " + o1);
        System.out.println("object 2 = " + o2);
        Assert.assertNotEquals(o1, o2);
    }
}