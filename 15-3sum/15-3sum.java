class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> tripletList = new ArrayList<>();
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prev == nums[i]) {
                continue;
            }
            getTripletWhichSumIsZero(nums, nums[i], i + 1, tripletList);

            prev = nums[i];
        }
        return tripletList;
    }
    
    private static void getTripletWhichSumIsZero(int[] nums, int target, int startIndex, List<List<Integer>>tripletList) {
        int endIndex = nums.length - 1;
        int prev = Integer.MIN_VALUE;
        while (startIndex < endIndex) {
            if (target + nums[startIndex] + nums[endIndex] == 0) {
                if (prev == nums[startIndex]) {
                    startIndex++;
                    continue;
                }

                tripletList.add(new ArrayList<>(Arrays.asList(target, nums[startIndex], nums[endIndex])));
                prev = nums[startIndex];
                startIndex++;
            } else if (target + nums[startIndex] + nums[endIndex] < 0) {
                startIndex++;
            } else {
                endIndex--;
            }
        }
    }
}