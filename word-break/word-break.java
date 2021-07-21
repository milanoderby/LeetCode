class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        List<Integer>[] endIndexOfWord = new List[s.length()];
        for (int i = 0; i < s.length(); i++) {
            endIndexOfWord[i] = new ArrayList<>();
        }

        for (String word : wordDict) {
            findWord(s, word, endIndexOfWord);
        }
        boolean[] isSegmented = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            isSegmented[i] = true;
        }
        return canBeSegmented(s, 0, endIndexOfWord, isSegmented);
    }
    
    private static void findWord(String s, String word, List<Integer>[] endIndexOfWord) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < word.length() && (i + j) < s.length(); j++) {
                if (s.charAt(i + j) != word.charAt(j)) {
                    break;
                }

                if (j == word.length() - 1) {
                    endIndexOfWord[i].add(i + j);
                }
            }
        }
    }

    private static boolean canBeSegmented(String s, int index, List<Integer>[] endIndexOfWord, boolean[] isSegmented) {
        if (index == s.length()) {
            return true;
        }

        if (!isSegmented[index]) {
            return false;
        }

        for (Integer endIndex : endIndexOfWord[index]) {
            if (canBeSegmented(s, endIndex + 1, endIndexOfWord, isSegmented)) {
                return true;
            }
        }
        return isSegmented[index] = false;
    }
}