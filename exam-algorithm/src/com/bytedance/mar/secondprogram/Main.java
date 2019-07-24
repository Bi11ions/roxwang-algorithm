package com.bytedance.mar.secondprogram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangsen@qgutech.com
 * @since 2019/3/16 10:33
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return;
        }

        if (1 > n) {
            return;
        }

        List<String> arrList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            arrList.add(line);
        }

        List<String> result = getNoRepeatString(arrList);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static List<String> getNoRepeatString(List<String> arrList) {
        List<String> result = new ArrayList<>(arrList.size());
        for (String s : arrList) {
            if (s.length() < 1) {
                result.add("");
                continue;
            }

            boolean flag = false;
            StringBuffer sb = new StringBuffer();
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                sb.append(c);
                i++;

                while (i < s.length() && s.charAt(i) == c) {
                    if (!flag) {
                        flag = true;
                        break;
                    }

                    i++;
                }

            }

            result.add(sb.toString());
        }

        return result;
    }
}
