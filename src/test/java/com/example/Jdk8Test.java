package com.example;

import com.xin.Application;
import com.xin.example.ForkJoin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Jdk8Test {

    @Test
    public void forkJoinTest() {
        //开始时间
        Instant start = Instant.now();

        //这里需要一个线程池的支持
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoin(0L, 10000000000L);
        // 没有返回值     pool.execute();
        // 有返回值
        long sum = pool.invoke(task);

        //结束时间
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());

    }
}
