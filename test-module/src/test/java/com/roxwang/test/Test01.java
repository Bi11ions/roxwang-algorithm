package com.roxwang.test;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.ReentrantLock;

import static javax.print.attribute.standard.PrinterStateReason.SHUTDOWN;

/**
 * @author wangsen@qgutech.com
 * @since 2019/7/10 17:38
 */
public class Test01 {

    @Test
    public void testAnd() {
        int capacity = 29;
        int num = 53687000;
        int result = num & capacity;
        System.out.println(result);
    }

    @Test
    public void testDateFormatter() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse("0000-00-00", dateTimeFormatter);
        System.out.println(dateTime.toString());
    }

    public void shutdown() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            // 安全策略判断
            checkShutdownAccess();
            // 切换状态为 SHUTDOWN
            advanceRunState(SHUTDOWN);
            // 中断空闲线程
            interruptIdleWorkers();
            onShutdown(); // hook for ScheduledThreadPoolExecutor
        } finally {
            mainLock.unlock();
        }
        // 尝试结束线程池
        tryTerminate();
    }
}
