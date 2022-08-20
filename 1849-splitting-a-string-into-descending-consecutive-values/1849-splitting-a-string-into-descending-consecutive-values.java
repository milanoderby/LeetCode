class Solution {
    public boolean splitString(String s) {
        long number = 0;
        for (int index = 0; index < s.length(); index++) {
            int digit = s.charAt(index) - '0';
            number *= 10;
            number += digit;

            if (splitStringByDifferenceOne(number, s, index + 1, false)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean splitStringByDifferenceOne(long prevNumber, String s, int startIndex,
        boolean splitTwoOrMore) {
        if (startIndex >= s.length()) {
            return splitTwoOrMore;
        }

        long number = 0;
        for (int index = startIndex; index < s.length(); index++) {
            int digit = s.charAt(index) - '0';
            number *= 10;
            number += digit;

            if (number > prevNumber) {
                return false;
            }

            if (number == prevNumber - 1) {
                if (splitStringByDifferenceOne(number, s, index + 1, true)) {
                    return true;
                }
            }
        }
        return false;
    }
}