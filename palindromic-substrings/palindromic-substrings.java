class Solution {
    public int countSubstrings(String s) {
        int countOfPalindromeSubstring = s.length();

        for (int i = 0; i < s.length(); i++) {
            for (int k = 1; 0 <= (i - k) && (i + k) < s.length(); k++) {
                if (s.charAt(i - k) == s.charAt(i + k)) {
                    countOfPalindromeSubstring++;
                } else {
                    break;
                }
            }

            for (int k = 0; 0 <= (i - k) && (i + k + 1) < s.length(); k++) {
                if (s.charAt(i - k) == s.charAt(i + k + 1)) {
                    countOfPalindromeSubstring++;
                } else {
                    break;
                }
            }
        }

        return countOfPalindromeSubstring;
    }
}