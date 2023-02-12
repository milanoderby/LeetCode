class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int sum = 0;
        int[] prefixSum = new int[words.length];
        for (int index = 0; index < words.length; index++) {
            if (isStartingAndEndingWithVowel(words[index])) {
                sum++;
            }
            prefixSum[index] = sum;
        }

        int[] answerArray = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int startIndex = query[0];
            int endIndex = query[1];

            int answer = prefixSum[endIndex];
            if (startIndex != 0) {
                answer -= prefixSum[startIndex - 1];
            }
            answerArray[index] = answer;
            index++;
        }
        return answerArray;
    }
    
    private static boolean isStartingAndEndingWithVowel(String str) {
        char startCharacter = str.charAt(0);
        switch (startCharacter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                break;
            default:
                return false;
        }

        char endCharacter = str.charAt(str.length() - 1);
        switch (endCharacter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}