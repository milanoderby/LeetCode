class Solution {
    private static int MAX_NUMBER = 1000;
    public boolean primeSubOperation(int[] nums) {
        boolean[] isPrime = new boolean[MAX_NUMBER + 1];
        for (int number = 2; number <= MAX_NUMBER; number++) {
            isPrime[number] = true;
        }

        List<Integer> primeNumberList = new ArrayList<>();
        for (int number = 2; number <= MAX_NUMBER; number++) {
            if (!isPrime[number]) {
                continue;
            }

            primeNumberList.add(number);
            for (int notPrimeNumber = number * number; notPrimeNumber <= MAX_NUMBER; notPrimeNumber += number) {
                isPrime[notPrimeNumber] = false;
            }
        }

        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                continue;
            }

            int prevNumber = nums[i - 1];
            int nextNumber = nums[i];
            for (Integer primeNumber : primeNumberList) {
                if (primeNumber >= prevNumber) {
                    break;
                }

                if (prevNumber - primeNumber < nextNumber) {
                    nums[i - 1] = prevNumber - primeNumber;
                    break;
                }
            }

            if (nums[i - 1] >= nums[i]) {
                return false;
            }
        }
        return true;
    }
}