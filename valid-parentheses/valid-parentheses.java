class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put(')', '(');
        parenthesesMap.put('}', '{');
        parenthesesMap.put(']', '[');

        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                characterStack.push(ch);
            } else {
                char counterPart = parenthesesMap.get(ch);
                if (characterStack.isEmpty()) {
                    return false;
                }

                if (characterStack.pop() != counterPart) {
                    return false;
                }
            }
        }
        if (!characterStack.isEmpty()) {
            return false;
        }
        return true;
    }
}