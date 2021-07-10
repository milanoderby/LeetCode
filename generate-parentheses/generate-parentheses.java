class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        makeParenthesis(n, 0, 0, "", answer);
        return answer;
    }
    
    private static void makeParenthesis(int totalParenthesis, int openedParenthesis, int closedParenthesis, String parenthesis, List<String> answer) {
        if (openedParenthesis >= totalParenthesis) {
            for (int i = 0; i < totalParenthesis - closedParenthesis; i++) {
                parenthesis += ')';
            }
            answer.add(parenthesis);
            return;
        }

        makeParenthesis(totalParenthesis, openedParenthesis + 1, closedParenthesis, parenthesis + '(', answer);
        if (openedParenthesis > closedParenthesis) {
            makeParenthesis(totalParenthesis, openedParenthesis, closedParenthesis + 1, parenthesis + ')', answer);
        }
    }
}