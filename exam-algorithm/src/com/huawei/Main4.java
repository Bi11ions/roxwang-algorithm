package com.huawei;

/**
 * 给定源字符串source 和target，源字符串中能通过串联形式形成目标字符串的子序列的最小数量。
 * 如果无法通过串联源字符串中的子序列来构造目标字符串，则输出-1
 *
 * 样例1
 *
 * 输入:source= "abc" target="abcbc"
 * 输出: 2
 * 解释 目标字符串abcbc可以由abc  bc形成，他们都是源字符串abc的子序列
 *
 * 样例2
 *
 * 输入:source= "abc" target="abcdc"
 * 输出: -1
 * 解释 目标字符串abcdc中的d无法由源字符串的子序列构建
 *
 * 样例3
 *
 * 输入:source= "xyz" target="xzyxz"
 * 输出: 3
 * 解释 目标字符串按照如下构建xz + y + xz
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println(shortestWay("xyz", "xzyxz"));
    }
    public static int shortestWay(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        int ways = 0;
        int sourceLength = source.length();
        int targetLength = target.length();
        int currentIndex = 0;
        while (currentIndex < targetLength) {
            boolean matched = false;
            for (int i = 0; i < sourceLength && currentIndex < targetLength; i++) {
                if (source.charAt(i) == target.charAt(currentIndex)) {
                    currentIndex++;
                    matched = true;
                }
            }
            if (!matched) {
                return -1;
            }
            ways++;
        }
        return ways;
    }
}
