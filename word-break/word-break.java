class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        List<Integer>[] endIndexOfWord = new List[s.length()];
        for (int i = 0; i < s.length(); i++) {
            endIndexOfWord[i] = new ArrayList<>();
        }

        for (String word : wordDict) {
            int[] pi = getPiArray(word);
            findWord(s, word, pi, endIndexOfWord);
        }
        boolean[] isSegmented = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            isSegmented[i] = true;
        }
        return canBeSegmented(s, 0, endIndexOfWord, isSegmented);
    }
    
    private static void findWord(String str, String pattern, int[] pi, List<Integer>[] endIndexOfWord) {
        for (int i = 0, j = 0; i + pattern.length() <= str.length(); ) {
            if (str.charAt(i + j) == pattern.charAt(j)) {
                j++;
                if (j >= pattern.length()) {
                    endIndexOfWord[i].add(i + j - 1);
                    i += j - pi[j - 1];
                    j = pi[j - 1];
                }
            } else {
                if (j > 0) {
                    i += j - pi[j - 1];
                    j = pi[j - 1];
                } else {
                    i++;
                }
            }
        }
    }
    
    private static int[] getPiArray(String str) {
        int[] pi = new int[str.length()];
        for (int i = 1, j = 0; i + j < str.length(); ) {
            if (str.charAt(i + j) == str.charAt(j)) {
                pi[i + j] = j + 1;
                j++;
            } else {
                if (j > 0) {
                    i += j - pi[j - 1];
                    j = pi[j - 1];
                } else {
                    i++;
                }
            }
        }
        return pi;
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