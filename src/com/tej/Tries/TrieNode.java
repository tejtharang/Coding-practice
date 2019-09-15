package com.tej.Tries;

public class TrieNode {
    // total number of trees from each node

    final int R = 26;
    public TrieNode [] links;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean containsKey(char c){
        return links[c-'a'] != null;
    }

    public void setLink(char c, TrieNode link){
        links[c-'a'] = link;
    }

    public TrieNode getLink(char c){
        return links[c-'a'];
    }
}
