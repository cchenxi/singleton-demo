package io.github.cchenxi.level2;

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
 * 测试 懒汉式单例
 * Date: 2021-10-02
 *
 * @author chenxi
 */
public class SingletonTest {

    @SneakyThrows
    @Test
    public void should_new_multi_instance() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future[] futures = new Future[2];
        for (int i = 0; i < 2; i++) {
            Future future = executorService.submit(new Task(cyclicBarrier));
            futures[i] = future;
        }

        Object o1 = futures[0].get();
        Object o2 = futures[1].get();
        System.out.println("object 1 = " + o1);
        System.out.println("object 2 = " + o2);

        boolean instanceEquals = Objects.equals(o1, o2);
        Assert.assertNotEquals(true, instanceEquals);
    }
}

class Task implements Callable {
    private CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @SneakyThrows
    @Override
    public Object call() {
        System.out.printf("%s 正在等待\n", Thread.currentThread().getName());
        // 模拟，等待所有线程都到达
        cyclicBarrier.await();
        return Singleton.getInstance();
    }
}
