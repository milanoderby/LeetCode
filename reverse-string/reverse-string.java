class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (i >= s.length - i - 1) {
                break;
            }
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}