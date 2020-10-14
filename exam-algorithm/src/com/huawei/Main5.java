package com.huawei;

/**
 * 回文子串的个数
 */
public class Main5 {

    public static void main(String[] args) {
        String str = "aabaa";
        System.out.println(getSameStringNum(str));
    }
    public static int getSameStringNum(String str) {
        if (null == str || str.length() < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += getCount(str, i, i);
            count += getCount(str, i, i+1);
        }
        return count;
    }
    public static int getCount(String str, int start, int end) {
        int count = 0;
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
