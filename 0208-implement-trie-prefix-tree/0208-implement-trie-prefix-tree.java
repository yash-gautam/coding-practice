class Node{
    Node[] nodes = new Node[26];
    boolean word = false;
    
    public Node(){
        
    }
    
    boolean containsKey(char ch){
        return nodes[ch-'a'] != null;
    }
    
    void put(char ch, Node node){
        nodes[ch-'a'] = node;
        return;
    }
    
    Node get(char ch){
        return nodes[ch-'a'];
    }
    
    void setWord(){
        word = true;
        return;
    }
    
    boolean isWord(){
        return word;
    }
}

class Trie {
    
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            if(!curr.containsKey(word.charAt(i))){
                curr.put(word.charAt(i), new Node());
            }
            
            curr = curr.get(word.charAt(i));
        }
        
        curr.setWord();
        return;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            if(!curr.containsKey(word.charAt(i))){
                return false;
            }
            
            curr = curr.get(word.charAt(i));
        }
        
        return curr.isWord();
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            if(!curr.containsKey(prefix.charAt(i))){
                return false;
            }
            
            curr = curr.get(prefix.charAt(i));
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