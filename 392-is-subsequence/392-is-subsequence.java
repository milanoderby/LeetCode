class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean isSubseq = true;
        int indexOfT = 0;
        for (int indexOfS = 0; indexOfS < s.length(); ) {
            if (indexOfT >= t.length()) {
                isSubseq = false;
                break;
            }

            if (s.charAt(indexOfS) == t.charAt(indexOfT)) {
                indexOfS++;
            }
            indexOfT++;
        }

        return isSubseq;
    }
}