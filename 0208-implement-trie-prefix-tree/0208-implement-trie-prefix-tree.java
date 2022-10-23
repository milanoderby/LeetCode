class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int numberOfChar = word.charAt(i) - 'a';
            if (temp.nextChar[numberOfChar] == null) {
                temp.nextChar[numberOfChar] = new Node();
            }

            temp = temp.nextChar[numberOfChar];
        }
        temp.isCompleteWord = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int numberOfChar = word.charAt(i) - 'a';
            if (temp.nextChar[numberOfChar] == null) {
                return false;
            }
            temp = temp.nextChar[numberOfChar];
        }
        return temp.isCompleteWord;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int numberOfChar = prefix.charAt(i) - 'a';
            if (temp.nextChar[numberOfChar] == null) {
                return false;
            }
            temp = temp.nextChar[numberOfChar];
        }
        return true;
    }
    
    private static class Node {
        private Node[] nextChar;
        private boolean isCompleteWord;

        public Node() {
            this.nextChar = new Node[26];
            this.isCompleteWord = false;
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