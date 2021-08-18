package com.yk.book.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串.
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * "abcabdebac"
 * "cda"
 *
 * "aBbaBBBBA"
 * "BBA"
 *
 * @author: yangkun
 * @create: 2021-08-17 19:21
 */
public class 最小覆盖子串 {


    public static void main(String[] args) {
//        String s1 = "ADOBECODEBANC";
//        String s2 = "ABC";

        String s1 = "ab";
        String s2 = "a";

//        String s1 = "bba";
//        String s2 = "ab";

//        String s1 = "aBbaBBBBA";
//        String s2 = "BBA";

        System.out.println(minWindow(s1,s2));
    }


    public static String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                map2.put(c, map2.get(c) + 1);
            } else {
                map.put(c, 1);
                map2.put(c, 1);
            }
        }

        int p = 0;
        int q = 0;

        int minP = p;
        while (q < s.length()) {
            char c = s.charAt(q++);
            if(map2.containsKey(c)){
                map2.put(c, map2.get(c) - 1);
            }
            if (map.containsKey(c)) {
                if (map.get(c) > 1) {
                    map.put(c, map.get(c) - 1);
                } else {
                    map.remove(c);

                    if(map.size() == 0){
                        break;
                    }
                }
            }
        }

        if(map.size() != 0){
            return "";
        }

        int maxQ = q;
        int min = maxQ - minP;

        char last = 'a';
        boolean moveP = true;
        while ((q < s.length() - 1 || moveP) && p <= q) {

            if(moveP){
                if(min > q - p){
                    minP = p;
                    maxQ = q;
                    min = q - p;
                }
                char c = s.charAt(p++);
                if(map2.containsKey(c)){
                    int count = map2.get(c) + 1;
                    map2.put(c,count);

                    if(count > 0){
                        last = c;
                        moveP = false;
                    }
                }
            }else {
                char c = s.charAt(++q);
                if(map2.containsKey(c)){
                    int count = map2.get(c) - 1;
                    map2.put(c,count);
                    if(c == last){
                        moveP = true;
                        if(min > q - p){
                            minP = p;
                            maxQ = q;
                            min = q - p;
                        }
                    }
                }
            }
        }

        return s.substring(minP, maxQ);
    }
}
