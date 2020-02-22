package 面试题38.字符串的排列;

import java.util.*;

class Solution {
    Map<String, Integer> map;

    public String[] permutation(String s) {
        map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(i, s.charAt(i));
        }
        dfs("", list);
        String[] ress = new String[map.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ress[index++] = entry.getKey();
        }
        return ress;
    }

    private int dfs(String cur, List<Character> list) {
        if (list.size() == 1) {
            if (!map.containsKey(cur + list.get(0)))
                map.put(cur + list.get(0), 0);
            return 1;
        }
        for (int i = 0; i < list.size(); i++) {
            String current = new String(cur);
            List<Character> temp = new ArrayList<>(list);
            current += temp.remove(i);
            dfs(current, temp);
        }
        return 1;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        String s[] = solution.permutation("abc");
        System.out.println("xxx");
    }
}