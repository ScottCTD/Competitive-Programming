package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Q3 {

    // This method is not my method.
    // The most effective one in Java.
    public static int lengthOfLongestSubstring03(String s) {
        int[] last = new int[128];
        int length = s.length();

        int res = 0;
        int start = 0;

        for (int i = 0; i < length; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    // Original
    // 9ms in leetcode
    public static int lengthOfLongestSubstring02(String s) {
        int length = 0;

        char[] chars = s.toCharArray();
        int originalLen = chars.length;

        for (int i = 0; i < originalLen; i++) {
            if (length >= originalLen - i) return length;
            boolean[] exist = new boolean[128];
            int temp = 0;
            for (int j = i; j < originalLen; j++) {
                if (!exist[chars[j]]) {
                    exist[chars[j]] = true;
                    temp++;
                } else {
                    break;
                }
            }
            if (temp > length) length = temp;
        }

        return length;
    }

    // Original
    // Not effective.
    public static int lengthOfLongestSubstring01(String s) {
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (length >= chars.length - i) break;
            List<Character> builder = new ArrayList<>(s.length() - i);
            for (int j = i; j < s.length(); j++) {
                if (!builder.contains(chars[j])) {
                    builder.add(chars[j]);
                    int temp = builder.size();
                    if (temp > length) {
                        length = temp;
                    }
                } else {
                    break;
                }
            }
        }
        return length;
    }

}