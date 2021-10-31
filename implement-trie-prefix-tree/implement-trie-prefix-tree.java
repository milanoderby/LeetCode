class Trie {

    private Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = this.root;
        for (int i = 0; i < word.length(); i++) {
            int character = word.charAt(i) - 'a';
            if (Objects.isNull(temp.next[character])) {
                temp.next[character] = new Node();
            }
            temp = temp.next[character];
        }
        temp.isCompleteWord = true;
    }

    public boolean search(String word) {
        Node temp = this.root;
        for (int i = 0; i < word.length(); i++) {
            int character = word.charAt(i) - 'a';
            if (Objects.isNull(temp.next[character])) {
                return false;
            }
            temp = temp.next[character];
        }

        if (temp.isCompleteWord) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        Node temp = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int character = prefix.charAt(i) - 'a';
            if (Objects.isNull(temp.next[character])) {
                return false;
            }
            temp = temp.next[character];
        }
        return true;
    }
    
    private static class Node {
        private Node[] next;
        private boolean isCompleteWord;
        public Node() {
            this.next = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */