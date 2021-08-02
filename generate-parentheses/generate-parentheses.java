class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        makeParenthese(answer, 0, 0, n, "");
        return answer;
    }
    
    private static void makeParenthese(List<String> answer, int countOfOpenParenthesis, int countOfClosingParenthesis, int countOfParenthesisPair, String parenthese) {
        if (countOfOpenParenthesis >= countOfParenthesisPair) {
            for (int i = 0; i < countOfParenthesisPair - countOfClosingParenthesis; i++) {
                parenthese += ')';
            }
            answer.add(parenthese);
            return;
        }

        makeParenthese(answer, countOfOpenParenthesis + 1, countOfClosingParenthesis, countOfParenthesisPair, parenthese + '(');
        if (countOfOpenParenthesis > countOfClosingParenthesis) {
            makeParenthese(answer, countOfOpenParenthesis, countOfClosingParenthesis + 1, countOfParenthesisPair, parenthese + ')');
        }
    }
}
