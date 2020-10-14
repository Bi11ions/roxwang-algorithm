package com.chengfayun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String row = in.next();
        if (null == row || row.length() < 1) {
            return;
        }

        String result = simplify(row);
        System.out.println(result);
    }

    private static String simplify(String path) {
        String[] strings = path.split("\\/");
        List<String> list = new ArrayList<>(strings.length);
        for (String string : strings) {
            if (string.equals(".") || string.equals("")) {
            } else if (string.equals("..")) {
                int size = list.size();
                if (size > 0) {
                    list.remove(size - 1);
                }
            } else {
                list.add(string);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (!s.equals("")) {
                stringBuilder.append(s).append("/");
            }
        }
        int length = stringBuilder.length();
        if (length == 0) {
            if (path.charAt(0) == '/') {
                return "/";
            } else {
                return ".";
            }
        } else {
            String s = stringBuilder.deleteCharAt(length - 1).insert(0, "/").toString();
            return s;
        }
    }
}