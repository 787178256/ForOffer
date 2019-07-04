package leetcode;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by kimvra on 2019-07-04
 */
public class _0208_Trie {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));   // 返回 true
        Assert.assertFalse(trie.search("app"));     // 返回 false
        Assert.assertTrue(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));     // 返回 true
    }


}
class TrieNode {
    boolean isWord;

    TrieNode[] child;

    public TrieNode() {
        this.isWord = false;
        this.child = new TrieNode[26];
    }
}
class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ptr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ptr.child[c-'a'] == null) {
                ptr.child[c-'a'] = new TrieNode();
            }
            ptr = ptr.child[c-'a'];
        }
        ptr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ptr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ptr.child[c-'a'] == null) {
                return false;
            }
            ptr = ptr.child[c-'a'];
        }
        return ptr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ptr.child[c-'a'] == null) {
                return false;
            }
            ptr = ptr.child[c-'a'];
        }
        return true;
    }
}
