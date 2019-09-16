package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-09-16
 */
public class _0126_Find_Ladders {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        return null;
    }
}
