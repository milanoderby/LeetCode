class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Trie trie = new Trie();
        for (int startIndex = 0; startIndex < s.length(); startIndex++) {
            int endIndex = Math.min(startIndex + 32, s.length());
            trie.insert(s, startIndex, endIndex);
        }

        int[][] answer = new int[queries.length][2];
        int indexOfAnswer = 0;
        for (int[] query : queries) {
            int value = query[0] ^ query[1];

            String valueString = Integer.toBinaryString(value);
            int index = trie.find(valueString);

            if (index == -1) {
                answer[indexOfAnswer][0] = -1;
                answer[indexOfAnswer][1] = -1;
            } else {
                answer[indexOfAnswer][0] = index - valueString.length() + 1;
                answer[indexOfAnswer][1] = index;
            }
            indexOfAnswer++;
        }
        return answer;
    }
    
    private static class Trie {
        private Node root;

        public Trie() {
            this.root = new Node(-1);
        }

        public void insert(String s, int start, int end) {
            Node temp = this.root;
            for (int index = start; index < end; index++) {
                int charIndex = s.charAt(index) - '0';
                if (temp.nextBinary[charIndex] == null) {
                    temp.nextBinary[charIndex] = new Node(index);
                }
                temp = temp.nextBinary[charIndex];
            }
        }

        public int find(String binaryString) {
            Node temp = this.root;
            for (int index = 0; index < binaryString.length(); index++) {
                int charIndex = binaryString.charAt(index) - '0';
                if (temp.nextBinary[charIndex] == null) {
                    return -1;
                }
                temp = temp.nextBinary[charIndex];
            }
            return temp.index;
        }
    }

    private static class Node {
        private Node[] nextBinary;
        private int index;

        public Node(int index) {
            this.nextBinary = new Node[2];
            this.index = index;
        }
    }
}