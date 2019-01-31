package com.chapter2;

import org.junit.Test;

/**
 * @author wangsen@qgutech.com
 * @since 2019/1/31 15:57
 */
public class Test1 {
    @Test
    public void test1() {
        int[] arr = {3, 2, -3, -1 , -5};
        System.out.println(MaxSubSum.fourthMethod(arr));
    }
}
