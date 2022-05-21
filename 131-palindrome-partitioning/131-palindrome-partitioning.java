class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        getPalindromeArray(s, isPalindrome);
        List<List<String>> answer = new ArrayList<>();
        getPalindromePartition(s, 0, isPalindrome, new ArrayList<>(), answer);
        return answer;
    }
    
    private static void getPalindromeArray(String s, boolean[][] isPalindrome) {
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else if (i + 1 == j) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]);
                }
            }
        }
    }

    private static void getPalindromePartition(String s, int index, boolean[][] isPalindrome,
        List<String> partition, List<List<String>> answer) {
        if (index >= s.length()) {
            answer.add(new ArrayList<>(partition));
            return;
        }

        for (int count = 1; count <= s.length() - index; count++) {
            if (!isPalindrome[index][index + count - 1]) {
                continue;
            }
            partition.add(s.substring(index, index + count));
            getPalindromePartition(s, index + count, isPalindrome, partition, answer);
            partition.remove(partition.size() - 1);
        }
    }
}