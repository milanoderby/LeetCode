class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letterOfDigit = new String[10];
        letterOfDigit[2] = "abc";
        letterOfDigit[3] = "def";
        letterOfDigit[4] = "ghi";
        letterOfDigit[5] = "jkl";
        letterOfDigit[6] = "mno";
        letterOfDigit[7] = "pqrs";
        letterOfDigit[8] = "tuv";
        letterOfDigit[9] = "wxyz";

        List<String> letterCombinationList = new ArrayList<>();
        if (digits.length() == 0) {
            return letterCombinationList;
        }

        getCombinationOfDigits(0, new StringBuilder(), letterCombinationList, digits, letterOfDigit);
        return letterCombinationList;
    }

    private static void getCombinationOfDigits(int index, StringBuilder letterCombination, List<String> letterCombinationList, String digits, String[] letterOfDigit) {
        if (index >= digits.length()) {
            letterCombinationList.add(letterCombination.toString());
            return;
        }

        int digitNum = digits.charAt(index) - '0';
        for (int i = 0; i < letterOfDigit[digitNum].length(); i++) {
            char letter = letterOfDigit[digitNum].charAt(i);
            letterCombination.append(letter);
            getCombinationOfDigits(index + 1, letterCombination, letterCombinationList, digits, letterOfDigit);
            letterCombination.deleteCharAt(index);
        }
    }
}