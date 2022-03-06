class Solution {
    public int numSubseq(int[] nums, int target) {
        // 수열 내의 수의 개수가 1개일 때에는 2배를 곱해서 target보다 작은 숫자의 수를 구한다.
        // 수열 내의 수의 개수가 2개 이상일 경우, 2 ^ (두 수 사이의 개수 + 1) - 1
        int answer = 0;
        int divisor = 1000000007;
        Arrays.sort(nums);
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 <= target) {
                answer++;
            }

            int upperBoundIndex = upperBound(nums, target - nums[i]);
            if (i >= upperBoundIndex) {
                break;
            }
            nList.add(upperBoundIndex - i);
        }

        answer += getPowerOfTwo(nList);
        answer += (divisor - nList.size());
        answer %= divisor;
        return answer;
    }
    
    // target 보다 작거나 같은 수 중 가장 뒤에 위치한 숫자의 index를 반환하는 메소드
    private static int upperBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[end] <= target) {
            return end;
        }

        if (nums[start] > target) {
            return -1;
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int getPowerOfTwo(List<Integer> nList) {
        if (nList.isEmpty()) {
            return 0;
        }
        int maxN = nList.get(0);
        Set<Integer> nSet = nList.stream().collect(Collectors.toSet());

        int result = 0;
        int powerOfTwo = 1;
        int divisor = 1000000007;
        for (int count = 1; count <= maxN; count++) {
            powerOfTwo *= 2;
            powerOfTwo %= divisor;
            if (nSet.contains(count)) {
                result += powerOfTwo;
                result %= divisor;
            }
        }
        return result;
    }
}