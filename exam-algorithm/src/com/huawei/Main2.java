package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        if (1 > times || 1000 < times) {
            return;
        }

        List<String> strList = new ArrayList<>(times);
        for (int i = 0; i < times; i++) {
            String str = sc.next();
            if (null == str || str.length() < 1) {
                continue;
            }

            strList.add(str);
        }

        for (String s : strList) {
            System.out.println(getAddedStr(s));
        }
    }

    public static String getAddedStr (String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int num = (chars[i] + getNumber(i)) % 123;
            if (97 > num) {
                num = num + 97;
            }

            sb.append((char) (num));
        }

        return sb.toString();
    }

    public static int getNumber(int i) {
        if (2 == i) {
            return 4;
        }

        if (1 == i) {
            return 2;
        }

        if (0 == i) {
            return 1;
        }


        return getNumber(i - 1) + getNumber(i - 2) + getNumber(i - 3);
    }
}
