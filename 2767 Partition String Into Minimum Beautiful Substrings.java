class Solution {
    private static Set<String> binaryStringOfPowerOfFiveSet = new HashSet<>();
    private static int CAN_NOT_MAKE_PARTITION = 20;
    private static int[][] dp;
    
    public int minimumBeautifulSubstrings(String s) {
        makeBinaryStringOfPowerOfFive();
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }

        int answer = getMinimumCountOfBeautifulSubstring(s, 0, s.length() - 1);
        return answer == CAN_NOT_MAKE_PARTITION ? -1 : answer;
    }
    
    // 1
    // 101
    // 11001
    // ...
    // 2^15 - 1 까지 5의 거듭제곱의 2이진수 string을 모두 구하고 이를 Set에 저장합니다.
    private static void makeBinaryStringOfPowerOfFive() {
        int maximumLimit = (1 << 15);
        for (int number = 1; number < maximumLimit; number *= 5) {
            binaryStringOfPowerOfFiveSet.add(Integer.toBinaryString(number));
        }
    }

    // 문자열 s의 substring(시작지점, 끝지점)을 beautiful substring 으로 구성되게 나눌 때
    // beautiful substring 의 갯수의 합의 최솟값
    private static int getMinimumCountOfBeautifulSubstring(String s, int start, int end) {
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        String currentString = s.substring(start, end + 1);
        if (binaryStringOfPowerOfFiveSet.contains(currentString)) {
            return dp[start][end] = 1;
        }

        if (currentString.length() == 1) {
            return dp[start][end] = CAN_NOT_MAKE_PARTITION;
        }

        int minCountOfBeautifulSubstring = CAN_NOT_MAKE_PARTITION;
        for (int mid = start; mid < end; mid++) {
            int leftCountOfBeautifulSubstring = getMinimumCountOfBeautifulSubstring(s, start, mid);
            int rightCountOfBeautifulSubstring = getMinimumCountOfBeautifulSubstring(s, mid + 1, end);

            if (leftCountOfBeautifulSubstring != CAN_NOT_MAKE_PARTITION && rightCountOfBeautifulSubstring != CAN_NOT_MAKE_PARTITION) {
                minCountOfBeautifulSubstring = Math.min(minCountOfBeautifulSubstring,
                    leftCountOfBeautifulSubstring + rightCountOfBeautifulSubstring);
            }
        }
        return dp[start][end] = minCountOfBeautifulSubstring;
    }
}