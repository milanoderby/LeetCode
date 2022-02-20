class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> indexOfCharacter = new HashMap<>();
        int maxLength = -1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int newStart = indexOfCharacter.getOrDefault(ch, start - 1) + 1;
            for (int j = start; j < newStart; j++) {
                int tempAlphabet = s.charAt(j);
                indexOfCharacter.remove(tempAlphabet);
            }

            start = Math.max(start, newStart);
            maxLength = Math.max(maxLength, i - start + 1);
            indexOfCharacter.put(ch, i);
        }

        return maxLength;
    }
}