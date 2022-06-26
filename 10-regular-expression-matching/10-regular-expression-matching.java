class Solution {
    public boolean isMatch(String s, String p) {
        return canMatch(s, p, 0, 0);
    }
    
    private static boolean canMatch(String string, String pattern, int indexOfString,
        int indexOfPattern) {
        while (indexOfString < string.length() && indexOfPattern < pattern.length()) {
            if (indexOfPattern + 1 < pattern.length()
                && pattern.charAt(indexOfPattern + 1) == '*') {
                char charOfPattern = pattern.charAt(indexOfPattern);
                char charOfString = string.charAt(indexOfString);
                if (charOfString == charOfPattern || charOfPattern == '.') {
                    if (canMatch(string, pattern, indexOfString + 1, indexOfPattern)) {
                        return true;
                    }
                }
                indexOfPattern += 2;
            } else {
                char charOfPattern = pattern.charAt(indexOfPattern);
                char charOfString = string.charAt(indexOfString);
                if (charOfString == charOfPattern || charOfPattern == '.') {
                    indexOfString++;
                    indexOfPattern++;
                } else {
                    return false;
                }
            }
        }

        if (indexOfString >= string.length()) {
            while (indexOfPattern + 1 < pattern.length()) {
                if (pattern.charAt(indexOfPattern + 1) != '*') {
                    break;
                }
                indexOfPattern += 2;
            }

            if (indexOfPattern >= pattern.length()) {
                return true;
            }
        }
        return false;
    }
}