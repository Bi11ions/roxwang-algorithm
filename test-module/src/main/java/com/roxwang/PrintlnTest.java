package com.roxwang;

public class PrintlnTest {
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!flag) {
                /*
                 情况1：注释这条println时，while会进入死循环
                 情况2：放开这条println时，在t2将flag=true后，会退出循环。
                        println内部使用到了同步锁，
                            根据JMM规范，在加锁使用到变量，会失效工作内存变量，从主内存中获取并刷新入工作内存
                            解锁后，会将工作内存中的变量刷入主存
                 */

                System.out.println(flag);
            }

            System.out.println(Thread.currentThread() + " stop ");
        }, "t1").start();

        Thread.sleep(1000);

        new Thread(() -> {
            flag = true;
            System.out.println(Thread.currentThread() + " flag changed");
        }, "t2").start();
    }
}
