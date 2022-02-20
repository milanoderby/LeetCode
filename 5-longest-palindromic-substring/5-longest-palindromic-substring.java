class Solution {
    public String longestPalindrome(String s) {
        int front = -1;
        int end = -1;
        int maxLengthOfPalindrome = -1;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else if (i + 1 == j && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;
                } else if (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;
                }

                if (isPalindrome[i][j] && maxLengthOfPalindrome < Math.abs(i - j)) {
                    maxLengthOfPalindrome = Math.abs(i - j);
                    front = i;
                    end = j;
                }
            }
        }

        return s.substring(front, end + 1);
    }
}