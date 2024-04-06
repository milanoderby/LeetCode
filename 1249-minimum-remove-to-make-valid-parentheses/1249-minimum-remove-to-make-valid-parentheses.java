class Solution {
    public String minRemoveToMakeValid(String s) {
        boolean[] indexToAdd = new boolean[s.length()];
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(ch);
                    indexStack.push(i);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        continue;
                    }
                    stack.pop();
                    Integer index = indexStack.pop();
                    indexToAdd[index] = true;
                    indexToAdd[i] = true;
                    break;
                default:
                    indexToAdd[i] = true;
                    break;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (indexToAdd[i]) {
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();
    }
}