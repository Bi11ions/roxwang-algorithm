package com.roxwang;

/**
 * @author wangsen@qgutech.com
 * @since 2019/8/18 22:13
 */
public class TestIntern {
    public static void main(String[] args) {
//        String software = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(software.intern() == software);
//
//        /*
//         *  JDK1.6 中intern() 方法会把首次遇到的字符串复制到永久代中，返回的也是永久代中这个字符串实例的引用
//         *  JDK1.7 中intern() 方法不会再复制实例，只是在字符串常量池中记录首次出现的实例的引用
//         *  返回 false，因为在创建字符串实例之前，java 这个字符串已经在字符串常量池有它的引用了
//         */
//        String java = new StringBuilder("ja").append("va").toString();
//        System.out.println(java.intern() == java);
    }
}
