package dynamic;

import java.util.HashSet;
import java.util.Set;

/**
 Given a string s and a dictionary of words dict, determine if s can be
 segmented into a space-separated sequence of one or more dictionary words.
 For example, given
 s ="leetcode",
 dict =["leet", "code"].
 Return true because"leetcode"can be segmented as"leet code".
 */
public class Solution {
    public static boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0 || dict.size() == 0) {
            return false;
        }
        int len = s.length();
        //状态保存
        boolean[] flags = new boolean[len + 1];
        flags[0] = true;

        for (int i = 1; i < len + 1; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if(flags[j] && dict.contains(s.substring(j, i))) {
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[len];
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("b");
        System.out.println(wordBreak("a", set));
    }
}
