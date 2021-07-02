class MinStack {

    private Stack<Integer> valueStack;
    private Stack<Integer> minValueStack;

    public MinStack() {
        valueStack = new Stack<>();
        minValueStack = new Stack<>();
    }

    public void push(int val) {
        valueStack.push(val);

        if (minValueStack.isEmpty()) {
            minValueStack.push(val);
        } else {
            int currentMinValue = minValueStack.peek();
            currentMinValue = Math.min(currentMinValue, val);
            minValueStack.push(currentMinValue);
        }
    }

    public void pop() {
        valueStack.pop();
        minValueStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minValueStack.peek();
    }
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */