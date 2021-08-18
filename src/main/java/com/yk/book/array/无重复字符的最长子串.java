package com.yk.book.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串.
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author: yangkun
 * @create: 2021-08-13 20:39
 */
public class 无重复字符的最长子串 {


    public static void main(String[] args) {
//        String s = "abcabcbb";
        String s = " ";
//        String s = "jbpnbwwd";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    /**
     * 暴力解法，使用双循环，选取基准点，循环。使用set保存字串，
     * 第一层循环：选取字串的起点
     * 第二层循环：判断不重复的情况下set最多能包含多少个元素，重复则跳出本层循环
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        byte[] bytes = s.getBytes();

        int max = 0;
        Set<Byte> cache = new HashSet<Byte>();
        for (int i = 0; i < bytes.length; i++) {
            for (int j = i; j < bytes.length; j++) {
                byte bByte = bytes[j];
                if (cache.contains(bByte)) {
                    max = Math.max(max, cache.size());
                    cache.clear();
                    break;
                } else {
                    cache.add(bByte);
                }
            }
            max = Math.max(max, cache.size());
        }

        return max;
    }

    /**
     * 滑动窗口
     *
     * 使用两个指针来代表一个窗口，规定：这个窗口内的字符串不存在重复
     *
     * 右指针不断向后移动，在将要发生移动时，会发生两种情况
     * 1、发现重复，则左指针右移一位，右指针不动
     * 2、未发现重复，则将右指针右移一位，记录此时窗口内长度
     * 不断重复这个过程，直到右指针移动到末端，所记录的长度最大值就是最长不重复字串。
     *
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if(s.length() == 0){
            return 0;
        }
        int p = 0;
        int q = 0;

        Set<Character> occ = new HashSet<Character>();
        occ.add(s.charAt(p));
        int max = occ.size();

        //这里为什么到末尾前一位就停呢？因为内部的逻辑是将右指针的下一位加入缓存，所以其实已经遍历完了
        while (q < s.length() - 1){
            if(occ.contains(s.charAt(q + 1))){
                occ.remove(s.charAt(p++));
            }else {
                occ.add(s.charAt(++q));
                max = Math.max(max,occ.size());
            }
        }
        return max;
    }
}
