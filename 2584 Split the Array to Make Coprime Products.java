class Solution {
    private static int MAX_NUMBER = 1_000_000;
    public int findValidSplit(int[] nums) {
        if (nums.length == 1) {
            return -1;
        }
        
        int[] smallestFactor = new int[MAX_NUMBER + 1];
        getSmallestFactorArray(smallestFactor);

        Map<Integer, Integer> factorCountOfLeftPart = new HashMap<>();
        Map<Integer, Integer> factorCountOfRightPart = new HashMap<>();

        for (int i = 0; i <= 0; i++) {
            addFactor(nums[i], factorCountOfLeftPart, smallestFactor);
        }

        for (int i = 1; i < nums.length; i++) {
            addFactor(nums[i], factorCountOfRightPart, smallestFactor);
        }

        if (factorCountOfLeftPart.keySet().stream().noneMatch(factorCountOfRightPart::containsKey)) {
            return 0;
        }

        for (int index = 1; index < nums.length - 1; index++) {
            addFactor(nums[index], factorCountOfLeftPart, smallestFactor);
            removeFactor(nums[index], factorCountOfRightPart, smallestFactor);

            if (factorCountOfLeftPart.keySet().stream().noneMatch(factorCountOfRightPart::containsKey)) {
                return index;
            }
        }
        return -1;
    }
    
    private static void getSmallestFactorArray(int[] smallestFactor) {
        boolean[] isPrime = new boolean[MAX_NUMBER + 1];
        for (int number = 2; number <= MAX_NUMBER; number++) {
            isPrime[number] = true;
        }

        for (int number = 2; number <= MAX_NUMBER; number++) {
            if (!isPrime[number]) {
                continue;
            }

            smallestFactor[number] = number;
            for (long multiple = (long) number * number; multiple <= MAX_NUMBER; multiple += number) {
                isPrime[(int) multiple] = false;
                if (smallestFactor[(int) multiple] == 0) {
                    smallestFactor[(int) multiple] = number;
                }
            }
        }
    }

    private static void addFactor(int number, Map<Integer, Integer> factorCountMap, int[] smallestFactor) {
        while (number != 1) {
            int factor = smallestFactor[number];
            int count = factorCountMap.getOrDefault(factor, 0);
            factorCountMap.put(factor, count + 1);

            number /= smallestFactor[number];
        }
    }

    private static void removeFactor(int number, Map<Integer, Integer> factorCountMap, int[] smallestFactor) {
        while (number != 1) {
            int factor = smallestFactor[number];
            int count = factorCountMap.get(factor);
            if (count == 1) {
                factorCountMap.remove(factor);
            } else {
                factorCountMap.put(factor, count - 1);
            }

            number /= smallestFactor[number];
        }
    }
}