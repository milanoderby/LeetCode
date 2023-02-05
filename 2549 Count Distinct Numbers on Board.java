class Solution {
    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        // Queue에도 추가합니다.
        // Queue에서 꺼낼 값이 없다면, 종료합니다.
        while (!queue.isEmpty()) {
            // Queue 에서 꺼낸 값을 number 라고 합니다.
            // (number - 1의 약수, 소수는 제외)를 구해서 Set에 추가합니다.
            int number = queue.poll();
            for (int divisor = 2; divisor < number; divisor++) {
                if ((number - 1) % divisor == 0) {
                    queue.add(divisor);
                    set.add(divisor);
                }
            }
        }

        return set.size();
    }
}