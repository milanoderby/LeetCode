class Solution {
    public int countSubstrings(String s) {
        int countOfPalindromeSubstring = 0;
        boolean[][] isSubString = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    isSubString[i][j] = true;
                } else if (i + 1 == j) {
                    isSubString[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    isSubString[i][j] = (s.charAt(i) == s.charAt(j)) && isSubString[i + 1][j - 1];
                }
                
                if (isSubString[i][j]) {
                    countOfPalindromeSubstring++;
                }
            }
        }
        return countOfPalindromeSubstring;
    }
}