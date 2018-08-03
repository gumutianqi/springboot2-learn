package me.weteam.threadpool;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import me.weteam.threadpool.task.SimpleTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 单元测试
 *
 * @author LarryKoo (larrykoo@126.com)
 * @date 2018/08/03 14:21
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ThreadTestCase {

    @Autowired
    private SimpleTask simpleTask;

    @Test
    public void testRunTaskOne() {
        log.info("================= run_task_one =======================");
        log.info("开始请求任务1");
        Stopwatch sw = Stopwatch.createStarted();

        simpleTask.doTaskOne("12345");

        log.info("完成请求任务1, 耗时：{}", sw.stop());

    }

    @Test
    public void testRunTaskTwo() throws ExecutionException, InterruptedException {
        log.info("================= run_task_two =======================");

        log.info("开始请求任务2");
        Stopwatch sw = Stopwatch.createStarted();

        Future<String> feature = simpleTask.doTaskTwo("12345");
        while (true) {
            if (feature.isDone()) {
                log.info("完成请求任务2，返回结果：{}， 耗时：{}", feature.get(), sw.stop());
                break;
            }
        }
    }

    @Test
    public void testRunTaskTwoPlus() throws ExecutionException, InterruptedException, TimeoutException {
        log.info("================= run_task_two_plus =======================");

        log.info("开始请求任务2");
        Stopwatch sw = Stopwatch.createStarted();

        Future<String> feature = simpleTask.doTaskTwo("12345");

        String result = feature.get(10, TimeUnit.SECONDS);
        log.info("完成请求任务2，返回结果：{}， 耗时：{}", result, sw.stop());
    }

}
