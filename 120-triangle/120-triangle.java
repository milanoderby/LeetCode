class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] minimumPathSum = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i <= 0) {
                    minimumPathSum[i][j] = triangle.get(i).get(j);
                    break;
                }

                int minimumSum = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    minimumSum = Math.min(minimumSum, minimumPathSum[i - 1][j - 1]);
                }
                
                if (j < i) {
                    minimumSum = Math.min(minimumSum, minimumPathSum[i - 1][j]);
                }
                minimumPathSum[i][j] = minimumSum + triangle.get(i).get(j);
            }
        }

        int answer = Integer.MAX_VALUE;
        int bottom = minimumPathSum.length - 1;
        for (int i = 0; i < minimumPathSum.length; i++) {
            answer = Math.min(answer, minimumPathSum[bottom][i]);
        }
        return answer;
    }
}