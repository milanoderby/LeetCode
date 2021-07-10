class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        StringBuilder letterCombination = new StringBuilder();
        makeLetterCombinations(digits, 0, letterCombination, answer);
        
        return answer;
    }
    
    private static void makeLetterCombinations(String digits, int index, StringBuilder letterCombination, List<String> answer) {
        if (index >= digits.length()) {
            if (letterCombination.length() > 0) {
                answer.add(letterCombination.toString());
            }
            return;
        }

        char numChar = digits.charAt(index);
        int offset = 3 * (numChar - '2') + (numChar > '7' ? 1 : 0);
        char startChar = (char) ('a' + offset);
        char endChar = (char) (numChar == '7' ||  numChar == '9'? startChar + 3 : startChar + 2);

        for (char ch = startChar; ch <= endChar; ch++) {
            letterCombination.append(ch);
            makeLetterCombinations(digits, index + 1, letterCombination, answer);
            letterCombination.deleteCharAt(index);
        }
    }
}