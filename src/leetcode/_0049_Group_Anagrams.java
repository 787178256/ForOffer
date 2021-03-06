package leetcode;

import java.util.*;

/**
 * Created by kimvra on 2019-03-13
 */
public class _0049_Group_Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        int i = 0;
        Map<String, Integer> hash = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if (!hash.containsKey(sortedStr)) {
                hash.put(sortedStr, i++);
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                res.add(tempList);
            } else {
                res.get(hash.get(sortedStr)).add(s);
            }
        }
        return res;
    }

    public static List<List<String>> reviewSolution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        int i = 0;
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, i++);
                List<String> list = new ArrayList<>();
                list.add(s);
                res.add(list);
            } else {
                res.get(map.get(sortedStr)).add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
    }
}
