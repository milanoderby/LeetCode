class Solution {
    public int numSquares(int n) {
        List<Integer> squareNumberList = new ArrayList<>();

        int number = 1;
        int squareNumber = 1;
        while (squareNumber <= n) {
            squareNumberList.add(squareNumber);

            number++;
            squareNumber = number * number;
        }

        int[] minSquareNumOfN = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            minSquareNumOfN[i] = Integer.MAX_VALUE;
        }

        for (int num = 1; num <= n; num++) {
            for (Integer square : squareNumberList) {
                int temp = num - square;
                if (temp >= 0) {
                    minSquareNumOfN[num] = Math.min(minSquareNumOfN[num], minSquareNumOfN[temp] + 1);
                } else {
                    break;
                }
            }
        }

        return minSquareNumOfN[n];
    }
}