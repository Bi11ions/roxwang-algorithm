package com.bytedance.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangsen@qgutech.com
 * @since 2019/3/15 22:00
 */
public class ProgramOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userNum = Integer.parseInt(sc.nextLine());
        if (0 == userNum) {
            return;
        }

        String userInfo = sc.nextLine();
        String[] userInfoArr = userInfo.split("\\s+");
        if (userInfoArr.length < 1 || userInfoArr.length != userNum) {
            return;
        }

        int[] userInfoNumArr = Arrays.stream(userInfoArr).mapToInt(Integer::valueOf).toArray();
        int groupNum = Integer.parseInt(sc.nextLine());
        if (groupNum == 0) {
            return;
        }

        List<int[]> groupList = new ArrayList<>(groupNum);
        boolean flag = false;
        for (int i = 0; i < groupNum; i++) {
            String group = sc.nextLine();
            String[] groupArr = group.split("\\s+");
            if (groupArr.length != 3) {
                flag = true;
                break;
            }

            int[] groupInfo = Arrays.stream(groupArr).mapToInt(Integer::valueOf).toArray();
            groupList.add(groupInfo);
        }

        if (!flag) {
            List<Integer> result = getResult(userInfoNumArr, groupList);
            for (Integer integer : result) {
                System.out.println(integer);
            }

            return;
        }

        System.out.println("输出参数有误");
    }

    private static List<Integer> getResult(int[] arr, List<int[]> groupList) {
        List<Integer> result = new ArrayList<>(groupList.size());
        for (int[] group : groupList) {
            int userNum = getUserNum(group[0], group[1], group[2], arr);
            result.add(userNum);
        }

        return result;
    }

    private static int getUserNum(Integer startIndex, Integer endIndex, Integer target, int[] arr) {
        if (startIndex > endIndex || startIndex > arr.length || endIndex > arr.length) {
            return 0;
        }

        if (startIndex == endIndex) {
            return 1;
        }

        int sum = 0;
        for (int i = startIndex - 1; i < endIndex - 1; i++) {
            if (target == arr[i]) {
                sum++;
            }
        }

        return sum;
    }
}
