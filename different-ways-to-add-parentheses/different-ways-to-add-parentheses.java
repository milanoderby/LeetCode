class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < expression.length(); i++) {
            if ('0' <= expression.charAt(i) && expression.charAt(i) <= '9') {
                num *= 10;
                num += expression.charAt(i) - '0';
            } else {
                nums.add(num);
                num = 0;

                operators.add(expression.charAt(i));
            }
        }
        nums.add(num);

        List<Integer>[][] answer = new ArrayList[nums.size()][nums.size()];
        for (int offset = 0; offset < nums.size(); offset++) {
            for (int start = 0; start + offset < nums.size(); start++) {
                int end = start + offset;
                answer[start][end] = new ArrayList<>();
                if (offset == 0) {
                    answer[start][end].add(nums.get(start));
                    continue;
                }

                for (int mid = start; mid < end; mid++) {
                    for (Integer left : answer[start][mid]) {
                        for (Integer right : answer[mid + 1][end]) {
                            switch (operators.get(mid)) {
                                case '+':
                                    answer[start][end].add(left + right);
                                    break;
                                case '-':
                                    answer[start][end].add(left - right);
                                    break;
                                case '*':
                                    answer[start][end].add(left * right);
                                    break;
                            }
                        }
                    }
                }
            }
        }

        return answer[0][nums.size() - 1];
    }
}