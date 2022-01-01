class Solution {
    public int minDistance(String word1, String word2) {
        int[][] editDistance = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            editDistance[i][0] = i;
        }

        for (int j = 0; j <= word2.length(); j++) {
            editDistance[0][j] = j;
        }

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    editDistance[i + 1][j + 1] = editDistance[i][j];
                } else {
                    int temp = Math.min(editDistance[i + 1][j], editDistance[i][j + 1]);
                    temp = Math.min(temp, editDistance[i][j]);
                    editDistance[i + 1][j + 1] = temp + 1;
                }
            }
        }
        return editDistance[word1.length()][word2.length()];
    }
}