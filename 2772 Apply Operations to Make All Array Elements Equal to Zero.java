class Solution {
    public boolean checkArray(int[] nums, int k) {
        int toDecrease = 0;
        Queue<Operation> operationQueue = new ArrayDeque<>();
        for (int startIndexToDecrease = 0; startIndexToDecrease < nums.length; startIndexToDecrease++) {
            while (!operationQueue.isEmpty()) {
                Operation operation = operationQueue.peek();
                if (operation.endIndex < startIndexToDecrease) {
                    toDecrease -= operation.decreaseCount;
                    operationQueue.poll();
                } else {
                    break;
                }
            }
            nums[startIndexToDecrease] -= toDecrease;

            if (nums[startIndexToDecrease] < 0) {
                return false;
            } else if (nums[startIndexToDecrease] == 0) {
                continue;
            }

            if (startIndexToDecrease + k - 1 >= nums.length) {
                return false;
            }

            toDecrease += nums[startIndexToDecrease];
            operationQueue.add(new Operation(startIndexToDecrease + k - 1, nums[startIndexToDecrease]));
            nums[startIndexToDecrease] = 0;
        }
        return true;
    }
    
    private static class Operation {
        private int endIndex;
        private int decreaseCount;

        public Operation(int endIndex, int decreaseCount) {
            this.endIndex = endIndex;
            this.decreaseCount = decreaseCount;
        }
    }
}