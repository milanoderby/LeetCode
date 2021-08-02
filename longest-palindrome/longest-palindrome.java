class Solution {
    public int longestPalindrome(String s) {
        int[] lowercaseCount = new int[26];
        int[] uppercaseCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                lowercaseCount[s.charAt(i) - 'a']++;
            } else {
                uppercaseCount[s.charAt(i) - 'A']++;
            }
        }

        boolean hasOddCount = false;
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (lowercaseCount[i] % 2 == 1) {
                hasOddCount = true;
            }
            answer += lowercaseCount[i] / 2 * 2;
        }

        for (int i = 0; i < 26; i++) {
            if (uppercaseCount[i] % 2 == 1) {
                hasOddCount = true;
            }
            answer += uppercaseCount[i] / 2 * 2;
        }

        return hasOddCount ? answer + 1 : answer;
    }
}