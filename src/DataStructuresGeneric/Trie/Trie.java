package DataStructuresGeneric.Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class TrieNode{
        Map<Character, TrieNode> childNodes;
        boolean endOfWord;
        TrieNode(){
            this.childNodes = new HashMap<>();
            this.endOfWord = false;
        }
    }

    private TrieNode root;

    Trie(){
        this.root = new TrieNode();
    }

    // insert iteratively
    public void insert(String word){
        TrieNode parser = this.root;
        for(Character c : word.toCharArray()){
            if(!parser.childNodes.containsKey(c)) {
                parser.childNodes.put(c, new TrieNode());
            }
            parser = parser.childNodes.get(c);
        }
        parser.endOfWord = true;
    }


    // insert Recursively
    // helper function
    public void insertRecursively(String word){
        insertRecursively(word, this.root, 0);
    }
    public void insertRecursively(String word, TrieNode node, int index){
        if(!node.childNodes.containsKey(word.charAt(index))){
            node.childNodes.put(word.charAt(index), new TrieNode());
        }
        node = node.childNodes.get(word.charAt(index));
        if(index == word.length()-1) {
            node.endOfWord = true;
            return;
        }

        insertRecursively(word, node, index + 1);
    }

    public boolean search(String word){
        TrieNode parser = this.root;
        for(Character c : word.toCharArray()){
            if(!parser.childNodes.containsKey(c))
                return false;
            parser = parser.childNodes.get(c);
        }
        return parser.endOfWord;
    }

}
