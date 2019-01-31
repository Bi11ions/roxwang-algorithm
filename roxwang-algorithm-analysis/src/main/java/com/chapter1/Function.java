package com.chapter1;

import java.util.Comparator;

/**
 * @author wangsen@qgutech.com
 * @since 2019/1/31 14:08
 */
public class Function {

    public static <T>T findMax(T[] arr, Comparator<? super T> comparable) {
        int maxIndex  = 0;
        for (int i = 0; i < arr.length; i++) {
            if (comparable.compare(arr[i], arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return arr[maxIndex];
    }

    static class CaseSensitiveCompare implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }

    static class Test1 {
        public static void main(String[] args) {
            String[] arr = {"ZEBRA", "alligator", "crocodile"};
            System.out.println(findMax(arr, new CaseSensitiveCompare()));
        }
    }
}
