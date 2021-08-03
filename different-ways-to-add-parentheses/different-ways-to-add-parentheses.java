class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<String> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < expression.length(); i++) {
            if ('0' <= expression.charAt(i) && expression.charAt(i) <= '9') {
                num += expression.charAt(i) - '0';
                num *= 10;
            } else {
                if (num != 0) {
                    num /= 10;
                }
                nums.add(String.valueOf(num));
                num = 0;

                operators.add(expression.charAt(i));
            }
        }
        if (num != 0) {
            num /= 10;
        }
        nums.add(String.valueOf(num));

        Set<String> expressionSet = new HashSet<>();
        getExpressionSet(nums, operators, expressionSet);

        List<Integer> answer = new ArrayList<>();
        for (String expr : expressionSet) {
            answer.add(getResult(expr));
        }

        return answer;
    }
    
    private static void getExpressionSet(List<String> nums, List<Character> operators, Set<String> expressionSet) {
        if (nums.size() == 1) {
            expressionSet.add(String.valueOf(nums.get(0)));
            return;
        }

        if (nums.size() == 2) {
            expressionSet.add('(' + nums.get(0) + operators.get(0) + nums.get(1) + ')');
            return;
        }

        for (int i = 0; i < operators.size(); i++) {
            List<String> newNums = new ArrayList<>(nums);
            List<Character> newOperators = new ArrayList<>(operators);
            newNums.set(i, '(' + newNums.get(i) + operators.get(i) + newNums.get(i + 1) + ')');
            newNums.remove(i + 1);
            newOperators.remove(i);
            getExpressionSet(newNums, newOperators, expressionSet);
        }
    }

    private static int getResult(String expression) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); ) {
            if (expression.charAt(i) == ')') {
                int num2 = nums.pop();
                char op = operators.pop();
                int num1 = nums.pop();

                int result = 0;
                switch (op) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                }
                nums.push(result);
                i++;
            } else if ('0' <= expression.charAt(i) && expression.charAt(i) <= '9') {
                int num = 0;
                while (i < expression.length()) {
                    if (!('0' <= expression.charAt(i) && expression.charAt(i) <= '9')) {
                        break;
                    }
                    num *= 10;
                    num += (expression.charAt(i) - '0');
                    i++;
                }
                nums.push(num);
            } else if (expression.charAt(i) != '(') {
                operators.push(expression.charAt(i));
                i++;
            } else {
                i++;
            }
        }

        return nums.pop();
    }
}