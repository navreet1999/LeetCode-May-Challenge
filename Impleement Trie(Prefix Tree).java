/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.*/


class Trie {

    class TrieNode{
        TrieNode[] children;
        boolean end;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.end = false;
            for(int i=0;i < 26; i++){
                this.children[i] = null;
            }
        }
    }
    
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(temp.children[index] == null){
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return temp.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */