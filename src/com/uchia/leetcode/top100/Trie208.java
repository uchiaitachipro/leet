package com.uchia.leetcode.top100;


/**
 * twitter amazon google
 */
public class Trie208 {

    private boolean isEnd;
    private Trie208[] child = new Trie208[26];

    /**
     * Initialize your data structure here.
     */
    public Trie208() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        Trie208 node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null) {
                node.child[index] = new Trie208();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie208 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }


    private Trie208 searchPrefix(String word) {
        Trie208 node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null){
                return null;
            }
            node = node.child[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie208 trie208 = new Trie208();
        trie208.insert("apple");
        System.out.println("result: " + trie208.search("apple"));
        System.out.println("result: " + trie208.search("app"));
    }

}
