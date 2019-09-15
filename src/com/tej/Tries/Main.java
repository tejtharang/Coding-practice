package com.tej.Tries;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hell");
        trie.insert("hallll");
        trie.insert("ha");

        System.out.println(trie.getPredictions("ha"));
    }
}
