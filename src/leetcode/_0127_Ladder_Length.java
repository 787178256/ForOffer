package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by kimvra on 2019-09-16
 */
public class _0127_Ladder_Length {
    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int layer = 1;
        int c = 1;
        boolean[] visited = new boolean[wordList.size()];
        while (!queue.isEmpty()) {
            String curWord = queue.poll();
            c--;
            if (curWord.equals(endWord)) {
                return layer;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (isMatch(curWord, wordList.get(i)) && !visited[i]) {
                    visited[i] = true;
                    queue.add(wordList.get(i));
                }
            }
            if (c == 0) {
                layer++;
                c = queue.size();
            }
        }
        return 0;
    }

    private boolean isMatch(String word, String target) {
        if (word.length() != target.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        System.out.println(ladderLength("red", "tax", list));
    }
}
