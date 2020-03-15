package 面试题50.第一个只出现一次的字符;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, false);
            else
                map.put(c, true);
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Boolean> entry = (Map.Entry<Character, Boolean>) iterator.next();
            if (entry.getValue())
                return entry.getKey();
        }
        return ' ';
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.firstUniqChar("leetcode");
    }
}