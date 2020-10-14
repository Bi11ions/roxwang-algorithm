package com.chengfayun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2-36 进制转换
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        if (null == string || 1 > string.length()) {
            return;
        }

        string = string.toLowerCase();
        String[] numberArr = string.split(" ");
        int fromBase  = Integer.parseInt(numberArr[0]);
        String number = numberArr[1];
        int toBase = Integer.parseInt(numberArr[2]);
        String result = convertNum(fromBase, number, toBase);
        System.out.println(result);
    }

    private static String convertNum(int fromBase, String number, int toBase) {
        int tenNumber = toTen(number, fromBase);
        return toTarget(tenNumber, toBase);
    }

    private static String toTarget(int tenNumber, int toBase) {
        if (0 == tenNumber) {
            return "0";
        }

        List<String> resultList = new ArrayList<>();
        while (tenNumber != 0) {
            resultList.add(tenNumber % toBase + "");
            tenNumber /= toBase;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = resultList.size() - 1; i >= 0 ; i--) {
            sb.append(resultList.get(i));
        }

        return sb.toString();
    }

    private static int toTen(String number, int fromBase) {
        int b = 1;
        int sum = 0;
        char[] chars = number.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char n = chars[i];
            if (n >= 'a') {
                sum += (n - 'a' + 10) * b;
            } else {
                sum += (n - '0') * b;
            }

            b *= fromBase;
        }

        return sum;
    }

}