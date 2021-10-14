class Solution {
    public int numTrees(int n) {
        int[] countOfUniqueBinaryTree = new int[n + 1];
        countOfUniqueBinaryTree[0] = 1;
        countOfUniqueBinaryTree[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                countOfUniqueBinaryTree[i] += countOfUniqueBinaryTree[j] * countOfUniqueBinaryTree[i - j - 1];
            }
        }

        return countOfUniqueBinaryTree[n]; 
    }
}