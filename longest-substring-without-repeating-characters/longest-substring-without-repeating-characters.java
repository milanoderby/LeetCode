class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> appearIndex = new HashMap<>();

        int answer = 0;
        int front = 0;
        for (int rear = 0; rear < s.length(); rear++) {
            char ch = s.charAt(rear);
            if (appearIndex.containsKey(ch)) {
                int newFront = appearIndex.get(ch) + 1;
                for (int i = front; i < newFront; i++) {
                    char removedChar = s.charAt(i);
                    appearIndex.remove(removedChar);
                }
                front = newFront;
            }
            appearIndex.put(ch, rear);

            answer = Math.max(answer, rear - front + 1);
        }
        return answer;
    }
}