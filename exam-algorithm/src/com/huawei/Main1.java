package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    /**
     * 7#6$5#12
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        if (null == inputStr || inputStr.length() < 1) {
            return;
        }

        String[] arr1 = inputStr.split("#");
        List<Integer> numList = new ArrayList<>(arr1.length);
        for (String str : arr1) {
            String[] $s = str.split("\\$");
            if ($s.length < 2) {
                numList.add(Integer.valueOf(str));
                continue;
            }

            int num = Integer.parseInt($s[0]);
            for (int i = 1; i < $s.length; i++) {
                num = getNumByRule2(num, Integer.parseInt($s[i]));
            }

            numList.add(num);
        }

        int sum = numList.get(0);
        for (int i = 1; i < numList.size(); i++) {
            sum = getNumByRule1(sum, numList.get(i));
        }

        System.out.println(sum);
    }

    public static int getNumByRule1(int num1, int num2) {
        return 2 * num1 + 3 * num2 + 4;
    }

    public static int getNumByRule2(int num1, int num2) {
        return 3 * num1 + num2 + 2;
    }
}
