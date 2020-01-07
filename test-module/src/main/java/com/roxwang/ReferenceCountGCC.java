package com.roxwang;

/**
 * @author wangsen@qgutech.com
 * @since 2019/8/18 22:28
 */
public class ReferenceCountGCC {
    private Object instance = null;

    private static final int _1MB = 1024 * 1024;
    /**
     * 这个成员属性的唯一意义就是占用点内存，以便能在 GC 日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountGCC countGCCA = new ReferenceCountGCC();
        ReferenceCountGCC countGCCB = new ReferenceCountGCC();

        countGCCA.instance = countGCCB;
        countGCCB.instance = countGCCA;

        countGCCA = null;
        countGCCB = null;

        System.gc();
    }
}

