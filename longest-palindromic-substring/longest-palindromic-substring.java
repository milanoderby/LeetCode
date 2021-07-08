class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String answer = null;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else if (i + 1 == j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        isPalindrome[i][j] = true;
                    }
                } else {
                    if (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        isPalindrome[i][j] = true;
                    }
                }

                if (isPalindrome[i][j] && maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    answer = s.substring(i, j + 1);
                }
            }
        }
        return answer;
    }
}