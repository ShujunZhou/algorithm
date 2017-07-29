package dynamic;

import java.util.ArrayList;

/**
 * Created by shu on 2017/7/29.
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 Return all possible palindrome partitioning of s.
 For example, given s ="aab",
 Return
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class Solution3 {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        palindrome(lists, list, s);
        return lists;
    }

    private void palindrome(ArrayList<ArrayList<String>> lists, ArrayList<String> list, String s) {
        if (s == null || s.length() == 0) {
            lists.add(new ArrayList<String>(list));
            return;
        }

        for (int i = 1; i < s.length() + 1; ++i) {
            String leftStr = s.substring(0, i);
            if (isPalindrome(leftStr)) {
                list.add(leftStr);
                palindrome(lists, list, s.substring(i, s.length()));
                list.remove(list.size() - 1);
            }
        }
    }

    //判断一个字符串是不是回文字符串
    private boolean isPalindrome(String s) {
        int len = s.length();
        int middle = len >> 1;
        for (int i = 0; i < middle; ++i) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
