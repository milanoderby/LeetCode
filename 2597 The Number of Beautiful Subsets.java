class Solution {
    private static int answer;
    public int beautifulSubsets(int[] nums, int k) {
        answer = 0;
        Arrays.sort(nums);
        boolean[] selected = new boolean[1001];
        Map<Integer, Integer> countOfSelected = new HashMap<>();
        getAnswer(nums, k, 0, countOfSelected, true);
        return answer - 1;
    }
    
    private static void getAnswer(int[] nums, int k, int index, Map<Integer, Integer> countOfSelected, boolean isBeautiful) {
        if (index >= nums.length) {
            if (isBeautiful) {
                answer++;
            }
            return;
        }

        // index 번째 num을 부분집합에 추가하지 않는 경우
        getAnswer(nums, k, index + 1, countOfSelected, isBeautiful);

        // index 번째 num을 부분집합에 추가하는 경우
        int num = nums[index];
        int count = countOfSelected.getOrDefault(num, 0);
        countOfSelected.put(num, count + 1);

        int numberDiffWithK = num - k;

        if (countOfSelected.getOrDefault(numberDiffWithK, 0) > 0) {
            isBeautiful = false;
        }
        getAnswer(nums, k, index + 1, countOfSelected, isBeautiful);

        countOfSelected.put(num, count);
    }
}