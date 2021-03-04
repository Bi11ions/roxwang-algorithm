package com.leetcode.all.No290;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母，str 包含了由单个空格分隔的小写字母。
 */
public class WordPattern {
    /**
     * 官方题解，使用 Hash 表的方式，时间复杂度为 O(n + m) n 为 pattern 长度，m 为 s 长度
     * <p>
     * 在本题中，我们需要判断字符与字符串之间是否恰好一一对应。即任意一个字符都对应着唯一的字符串，任意一个字符串也只被唯一的一个字符对应。
     * 在集合论中，这种关系被称为「双射」。
     * <p>
     * 想要解决本题，我们可以利用哈希表记录每一个字符对应的字符串，以及每一个字符串对应的字符。然后我们枚举每一对字符与字符串的配对过程，
     * 不断更新哈希表，如果发生了冲突，则说明给定的输入不满足双射关系。
     * <p>
     * 在实际代码中，我们枚举 pattern 中的每一个字符，利用双指针来均摊线性地找到该字符在 str 中对应的字符串。
     * 每次确定一个字符与字符串的组合，我们就检查是否出现冲突，最后我们再检查两字符串是否比较完毕即可。
     */
    public boolean wordPattern2(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }

        // 确认是否比较完毕
        return i >= m;
    }

    /**
     * 时间复杂度：2 * (1 + 2 + 3 ... + n) = (n^2)/2 约等于 n^2
     */
    public boolean wordPattern(String pattern, String s) {
        if (null == pattern || 0 == pattern.length() || null == s || 0 == s.length()) {
            return false;
        }

        char[] chars = pattern.toCharArray();
        int[] patternIndexArr = new int[chars.length];
        String[] arr = s.split(" ");
        if (chars.length != arr.length) {
            return false;
        }

        patternIndexArr[0] = chars[0];
        for (int i = 1; i < chars.length; i++) {
            boolean matched = false;
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j]) {
                    patternIndexArr[i] = j;
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                patternIndexArr[i] = i;
            }
        }

        for (int i = 1; i < chars.length; i++) {
            int index = patternIndexArr[i];
            if (index != i) {
                if (!arr[i].equals(arr[index])) {
                    return false;
                }

                continue;
            }

            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        boolean result = wordPattern.wordPattern("abc", "dog egg fire");
        System.out.println(result);
    }
}
