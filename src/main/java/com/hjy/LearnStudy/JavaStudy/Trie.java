package com.hjy.LearnStudy.JavaStudy;

import java.util.Timer;

public class Trie {
    public static void main(String[] args) {
        int maxXor = 0;
        maxXor <<= 1;
        int currXor = maxXor | 1;
        System.out.println(currXor);
    }
    private boolean isEnd = false;
    private Trie[] next = new Trie[26];

    public Trie() {}

    public void insert (String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            if (root.next[now - 'a'] == null) {
                root.next[now - 'a'] = new Trie();
            }
            root = root.next[now - 'a'];
        }
        root.isEnd = true;
    }

    public Trie hasPrefix(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            if (root.next[now - 'a'] != null) {
                root = root.next[now - 'a'];
            } else {
                return null;
            }
        }
        return root;
    }

    public boolean search(String word) {
        Trie root = this;
        for (char ch : word.toCharArray()) {
            if (root.next[ch - 'a'] == null) {
                return false;
            }
            root = root.next[ch - 'a'];
        }
        return root.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        for (char ch : prefix.toCharArray()) {
            if (root.next[ch - 'a'] == null) {
                return false;
            }
            root = root.next[ch - 'a'];
        }
        return true;
    }
}
