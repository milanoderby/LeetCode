class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int countOfZero = 0;
        int indexOfZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countOfZero++;
                indexOfZero = i;
                continue;
            }
            product *= nums[i];
        }

        int[] answer = new int[nums.length];
        if (countOfZero > 1) {
            return answer;
        }

        if (countOfZero == 1) {
            answer[indexOfZero] = product;
            return answer;
        }
        
        for (int i = 0; i < nums.length; i++) {
            answer[i] = product / nums[i];
        }
        return answer;
    }
}