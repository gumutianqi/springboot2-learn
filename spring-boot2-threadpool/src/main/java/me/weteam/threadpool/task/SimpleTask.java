package me.weteam.threadpool.task;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * SimpleTask
 *
 * @author LarryKoo (larrykoo@126.com)
 * @date 2017/12/25 14:21
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Slf4j
@Component
public class SimpleTask {


    /**
     * 普通任务，无返回结果
     *
     * @param data
     */
    @Async("taskExecutor")
    public void doTaskOne(String data) {
        try {
            log.info("doTaskTwo ==》 start");
            Stopwatch sw = Stopwatch.createStarted();

            Thread.sleep(3000);

            log.info("doTaskTwo ==》 done， 耗时：{}", sw.stop());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 有返回结果，通过 AsyncResult 异步获取
     *
     * @param data
     * @return
     */
    @Async("taskExecutor")
    public Future<String> doTaskTwo(String data) {
        try {
            log.info("doTaskTwo ==》 start");
            Stopwatch sw = Stopwatch.createStarted();

            Thread.sleep(3000);

            log.info("doTaskTwo ==》 done 耗时：{}", sw.stop());

            return new AsyncResult<>(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
