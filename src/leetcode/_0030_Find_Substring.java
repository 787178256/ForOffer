package leetcode;

import java.util.*;

/**
 * Created by kimvra on 2019-03-08
 */
public class _0030_Find_Substring {
    public List<Integer> findSubString(String s, String[] words) {
        if (s == null) return Collections.emptyList();
        int len = s.length();
        if (len == 0) return Collections.emptyList();
        int wordsSize = words.length;
        if (wordsSize == 0) return Collections.emptyList();
        int wordLen = words[0].length(), end = len - wordsSize * wordLen;
        if (end < 0) return Collections.emptyList();
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        Set<Integer> ignores = new HashSet<>();
        for (int i = 0; i <= end; ++i) {
            if (ignores.contains(i)) continue;
            Map<String, Integer> findMap = new HashMap<>();
            int st = i, count = 0;
            List<Integer> ignore = new ArrayList<>();
            for (int j = 0; ; ++j) {
                int cur = i + j * wordLen;
                if (cur + wordLen > len) break;
                String word = s.substring(cur, cur + wordLen);
                if (countMap.containsKey(word)) {
                    findMap.put(word, findMap.getOrDefault(word, 0) + 1);
                    ++count;
                    while (findMap.get(word) > countMap.get(word)) {
                        ignore.add(st);
                        String tmp = s.substring(st, st += wordLen);
                        findMap.put(tmp, findMap.get(tmp) - 1);
                        --count;
                    }
                    if (count == wordsSize) {
                        ignore.add(st);
                        res.add(st);
                        String tmp = s.substring(st, st += wordLen);
                        findMap.put(tmp, findMap.get(tmp) - 1);
                        --count;
                    }
                } else {
                    for (int k = i; k <= cur; k += wordLen) {
                        ignore.add(k);
                    }
                    break;
                }
            }
            ignores.addAll(ignore);
        }
        return res;
    }
}
