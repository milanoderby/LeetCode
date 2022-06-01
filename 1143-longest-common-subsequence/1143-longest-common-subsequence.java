class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] lcsArray = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                int currentLcs = 0;
                if (i > 0 && j > 0) {
                    currentLcs = lcsArray[i - 1][j - 1];
                }
                
                currentLcs = text1.charAt(i) == text2.charAt(j) ? currentLcs + 1 : currentLcs;
                
                int prevRowLcs = 0;
                if (i > 0) {
                    prevRowLcs = lcsArray[i - 1][j];
                }
                currentLcs = Math.max(currentLcs, prevRowLcs);
                
                int prevColLcs = 0;
                if (j > 0) {
                    prevColLcs = lcsArray[i][j - 1];
                }
                currentLcs = Math.max(currentLcs, prevColLcs);
                
                lcsArray[i][j] = currentLcs;
            }
        }
        
        return lcsArray[text1.length() - 1][text2.length() - 1];
    }
}