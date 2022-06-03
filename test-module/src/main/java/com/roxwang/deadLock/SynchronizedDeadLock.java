package com.roxwang.deadLock;

public class SynchronizedDeadLock implements Runnable {
    private static final String LOCK_1 = "LOCK1";
    private static final String LOCK_2 = "LOCK2";
    private boolean flag;

    public SynchronizedDeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "运行");
        if (flag) {
            synchronized (LOCK_1) {
                System.out.println(Thread.currentThread().getName() + "锁住LOCK_1");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                synchronized (LOCK_2) {
                    // 执行不到这里
                    System.out.println("1秒钟后，" + Thread.currentThread().getName() + "锁住LOCK_2");
                }
            }
        } else {
            synchronized (LOCK_2) {
                System.out.println(Thread.currentThread().getName() + "锁住LOCK_2");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                synchronized (LOCK_1) {
                    // 执行不到这里
                    System.out.println("1秒钟后，" + Thread.currentThread().getName() + "锁住LOCK_1");
                }
            }
        }
    }


    public static void main(String[] args) {
        SynchronizedDeadLock lock1 = new SynchronizedDeadLock(false);
        SynchronizedDeadLock lock2 = new SynchronizedDeadLock(true);
        Thread thread1 = new Thread(lock1, "线程1");
        Thread thread2 = new Thread(lock2, "线程2");
        thread1.start();
        thread2.start();
    }
}
