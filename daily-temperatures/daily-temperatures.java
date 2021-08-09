class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Temperature> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            Temperature today = new Temperature(i, temperatures[i]);
            while (!stack.isEmpty()) {
                Temperature tempOfPast = stack.peek();
                if (tempOfPast.temperature < today.temperature) {
                    answer[tempOfPast.day] = today.day - tempOfPast.day;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new Temperature(i, temperatures[i]));
        }
        return answer;
    }
    
    private static class Temperature {
        private int day;
        private int temperature;

        public Temperature(int day, int temperature) {
            this.day = day;
            this.temperature = temperature;
        }
    }
}