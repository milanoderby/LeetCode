class Solution {
    public int maxScore(int[] nums) {
        List<Integer> numList = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList());

        Collections.sort(numList, Collections.reverseOrder());

        int answer = 0;
        long sum = 0;
        for (Integer number : numList) {
            sum += number;
            if (sum <= 0) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}