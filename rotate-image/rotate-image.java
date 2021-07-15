class Solution {
    public void rotate(int[][] matrix) {
        // i와 j를 바꾼 후,
        // j의 출력 순서를 역순으로 한다.

        int[][] answer = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                answer[i][j] = matrix[matrix.length - j - 1][i];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = answer[i][j];
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}