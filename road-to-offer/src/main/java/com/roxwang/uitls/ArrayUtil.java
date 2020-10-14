package com.roxwang.uitls;

/**
 * @author wangsen@qgutech.com
 * @since 2019/7/21 23:11
 */
public class ArrayUtil {
    public static void swap(int sourceIndex, int targetIndex, int[] nums) {
        int temp = nums[sourceIndex];
        nums[sourceIndex] = nums[targetIndex];
        nums[targetIndex] = temp;
    }

    /**
     * 判断两数组是否全等(元素相同，但顺序不一定相同)
     *
     * @return boolean
     */
    public static boolean simpleEqual(int[] arrayOrigin, int[] arrayClone) {
        if (null == arrayOrigin && null == arrayClone) {
            return true;
        }

        if (null == arrayOrigin || null == arrayClone) {
            return false;
        }

        if (arrayOrigin.length != arrayClone.length) {
            return false;
        }

        int length = arrayOrigin.length;
        for (int i = 0; i < length; i++) {
            if (containsValue(arrayClone, arrayOrigin[i])) {
                arrayClone = removeValue(arrayClone, arrayOrigin[i]);
            }
        }

        return 0 == arrayClone.length;
    }

    /**
     * 删除目标值，若不包含目标值，则返回与原数组相同的数组，否则返回新数组
     * 注意：
     *      删除第一个与目标值匹配的
     *
     *
     * @param array 数组
     * @param removeValue 删除目标
     * @return 新数组
     */
    public static int[] removeValue(int[] array, int removeValue) {
        if (null == array || array.length < 1) {
            return new int[]{};
        }

        int[] copyArray = new int[array.length - 1];
        int copyIndex = 0;
        boolean removed = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == removeValue && !removed) {
                removed = true;
                continue;
            }

            copyArray[copyIndex++] = array[i];
        }

        return copyArray;
    }

    /**
     * 判断数组中是否包含改值
     *
     * @param array 数组
     * @param targetValue 目标值
     * @return 是否存在
     */
    public static boolean containsValue(int[] array, int targetValue) {
        if (null == array || array.length < 1) {
            return false;
        }

        for (int value : array) {
            if (value == targetValue) {
                return true;
            }
        }

        return false;
    }
}
