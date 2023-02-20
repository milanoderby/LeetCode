class Solution {
    public int minimumScore(String s, String t) {
        int minimumScore = Integer.MAX_VALUE;
        List<Integer> endIndexListOfPrefix = new ArrayList<>();

        int indexOfT = 0;
        int indexOfS = 0;
        // t의 prefix로 만들 수 있는 s의 부분문자열을 찾습니다.
        while (indexOfT < t.length() && indexOfS < s.length()) {
            if (t.charAt(indexOfT) == s.charAt(indexOfS)) {
                endIndexListOfPrefix.add(indexOfS);
                minimumScore = Math.min(minimumScore, t.length() - (indexOfT + 1));
                indexOfT++;
            }
            indexOfS++;
        }

        indexOfT = t.length() - 1;
        indexOfS = s.length() - 1;
        int index = endIndexListOfPrefix.size() - 1;
        while (indexOfT >= 0 && indexOfS >= 0) {
            if (t.charAt(indexOfT) == s.charAt(indexOfS)) {
                while (index >= 0) {
                    if (endIndexListOfPrefix.get(index) >= indexOfS) {
                        index--;
                    } else {
                        break;
                    }
                }

                int newScore = t.length() - (index + 1) - (t.length() - indexOfT);
                newScore = newScore < 0 ? 0 : newScore;
                minimumScore = Math.min(minimumScore, newScore);
                indexOfT--;
            }
            indexOfS--;
        }
        return minimumScore == Integer.MAX_VALUE ? t.length() : minimumScore;
    }
}