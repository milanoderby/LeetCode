class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (isVowelCharacter(word.charAt(0)) && isVowelCharacter(word.charAt(word.length() - 1))) {
                answer++;
            }
        }
        return answer;
    }
    
    private static boolean isVowelCharacter(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }
}