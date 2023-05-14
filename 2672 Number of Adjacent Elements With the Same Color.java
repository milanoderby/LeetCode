class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int newColor = queries[i][1];

            int countOfSameColorBeforeQuery = 0;
            if (index - 1 >= 0 && colors[index - 1] != 0 && colors[index - 1] == colors[index]) {
                countOfSameColorBeforeQuery++;
            }

            if (index + 1 < n && colors[index] != 0 && colors[index + 1] == colors[index]) {
                countOfSameColorBeforeQuery++;
            }

            colors[index] = newColor;
            
            int countOfSameColorAfterQuery = 0;
            if (index - 1 >= 0 && colors[index - 1] != 0 && colors[index - 1] == colors[index]) {
                countOfSameColorAfterQuery++;
            }

            if (index + 1 < n && colors[index] != 0 && colors[index + 1] == colors[index]) {
                countOfSameColorAfterQuery++;
            }

            int beforeAnswer = i == 0 ? 0 : answer[i - 1];
            answer[i] = beforeAnswer - countOfSameColorBeforeQuery + countOfSameColorAfterQuery;
        }
        return answer;
    }
}