package me.weteam.threadpool.controller;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import me.weteam.threadpool.task.SimpleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * TODO
 *
 * @author LarryKoo (larrykoo@126.com)
 * @date 2017/12/25 14:21
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Slf4j
@RestController
public class ThreadController {

    @Autowired
    private SimpleTask simpleTask;

    @GetMapping("/run_task_one")
    public Mono<String> runTaskOne() {
        log.info("================= run_task_one =======================");
        log.info("开始请求任务1");
        Stopwatch sw = Stopwatch.createStarted();

        simpleTask.doTaskOne("12345");

        log.info("完成请求任务1, 耗时：{}", sw.stop());
        return Mono.just("Hello World, Run Done!");

    }

    @GetMapping("/run_task_two")
    public Mono<String> runTaskTwo() throws ExecutionException, InterruptedException {
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
        return Mono.just("Hello World, Run Done!");
    }

    @GetMapping("/run_task_two_plus")
    public Mono<String> runTaskTwoPlus() throws ExecutionException, InterruptedException, TimeoutException {
        log.info("================= run_task_two_plus =======================");

        log.info("开始请求任务2");
        Stopwatch sw = Stopwatch.createStarted();

        Future<String> feature = simpleTask.doTaskTwo("12345");

        String result = feature.get(10, TimeUnit.SECONDS);
        log.info("完成请求任务2，返回结果：{}， 耗时：{}", result, sw.stop());

        return Mono.just("Hello World, Run Done!");
    }


}
