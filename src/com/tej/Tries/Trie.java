package com.tej.Tries;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){

        // iterate over each letter
        //      inside the loop, go over each letter and check if it exists in the current trieNode.
        //      if yes, get it
        //      else, create a new Node
        // Mark the end
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.containsKey(c))
                node.setLink(c,new TrieNode());
            node = node.getLink(c);
        }
        node.setEnd(true);
    }

    /*
        With the dfs function
        Input : node
        Output : void

        steps to be done
        1. Check if the current string is at an end.
        2. Else, keep going.
     */

    public char convertCharToInt(int i){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        if(i>25)
            return '-';
        return alphabet.charAt(i);
    }

    public void dfs(TrieNode node, List<String> list, String word){

        StringBuilder sb = new StringBuilder(word);
        if(node.isEnd())
            list.add(sb.toString());
        for(int i=0;i<node.R;i++){
            if(node.links[i] != null) {
                sb.append(convertCharToInt(i));
                dfs(node.links[i], list, sb.toString());
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public List<String> getPredictions(String word) {

        List<String> predictions = new ArrayList<>();
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.containsKey(c))
                return predictions;
            node = node.getLink(c);
        }

        dfs(node, predictions, word);

        return predictions;
    }
}
