class Solution {
    public boolean checkValidString(String s) {
        Stack<CharIndex> leftParenthesisStack = new Stack<>();
        Stack<CharIndex> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    leftParenthesisStack.push(new CharIndex(ch, i));
                    break;
                case ')':
                    if (leftParenthesisStack.isEmpty() && starStack.isEmpty()) {
                        return false;
                    }

                    if (leftParenthesisStack.isEmpty()) {
                        starStack.pop();
                    } else {
                        leftParenthesisStack.pop();
                    }
                    break;
                default:
                    starStack.push(new CharIndex(ch, i));
                    break;
            }
        }

        while (!leftParenthesisStack.isEmpty()) {
            if (starStack.isEmpty()) {
                return false;
            }
            CharIndex leftParenthesis = leftParenthesisStack.pop();
            CharIndex star = starStack.pop();
            if (leftParenthesis.index > star.index) {
                return false;
            }
        }
        return true;
    }
    
    private static class CharIndex {
        private char ch;
        private int index;

        public CharIndex(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }
}