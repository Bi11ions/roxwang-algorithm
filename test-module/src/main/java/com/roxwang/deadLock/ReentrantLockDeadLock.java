package com.roxwang.deadLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDeadLock implements Runnable {
    private boolean flag;
    private static final ReentrantLock LOCK_1 = new ReentrantLock();
    private static final ReentrantLock LOCK_2 = new ReentrantLock();

    public ReentrantLockDeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            if (flag) {
                LOCK_1.lock();
                System.out.println(Thread.currentThread().getName() + "获取了Lock1");
                Thread.sleep(1000);
                LOCK_2.lock();
                System.out.println(Thread.currentThread().getName() + "获取了Lock2");
            } else {
                LOCK_2.lock();
                System.out.println(Thread.currentThread().getName() + "获取了Lock2");
                Thread.sleep(1000);
                LOCK_1.lock();
                System.out.println(Thread.currentThread().getName() + "获取了Lock1");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            if (LOCK_1.isHeldByCurrentThread()) {
                LOCK_1.unlock();
            }
            if (LOCK_2.isHeldByCurrentThread()) {
                LOCK_2.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDeadLock lock1 = new ReentrantLockDeadLock(true);
        ReentrantLockDeadLock lock2 = new ReentrantLockDeadLock(false);
        Thread thread1 = new Thread(lock1, "线程1");
        Thread thread2 = new Thread(lock2, "线程2");
        thread1.start();
        thread2.start();

        try {
            thread1.join(1000);
            thread2.join(1000);
            thread1.interrupt();
            thread2.interrupt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // 执行不到
        System.out.println("结束");
    }
}
