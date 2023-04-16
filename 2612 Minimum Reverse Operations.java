class Solution {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        boolean[] isBanned = new boolean[n];
        for (int num : banned) {
            isBanned[num] = true;
        }

        boolean[] isVisited = new boolean[n];
        Queue<Integer> visitNumberQueue = new ArrayDeque<>();
        int[] operationCount = new int[n];
        for (int i = 0; i < n; i++) {
            operationCount[i] = -1;
        }

        operationCount[p] = 0;
        visitNumberQueue.add(p);
        isVisited[p] = true;

        TreeSet<Integer> oddSet = new TreeSet<>();
        TreeSet<Integer> evenSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (i == p || isBanned[i]) {
                continue;
            }

            if (i % 2 == 0) {
                evenSet.add(i);
            } else {
                oddSet.add(i);
            }
        }

        while (!visitNumberQueue.isEmpty()) {
            int cur = visitNumberQueue.poll();

            int minOfSubArrayStartIndex = Math.max(0, cur - (k - 1));
            int minOfSubArrayEndIndex = minOfSubArrayStartIndex + (k - 1);
            int minNext = minOfSubArrayStartIndex + minOfSubArrayEndIndex - cur;

            int maxOfSubArrayEndIndex = Math.min(n - 1, cur + (k - 1));
            int maxOfSubArrayStartIndex = maxOfSubArrayEndIndex - (k - 1);
            int maxNext = maxOfSubArrayStartIndex + maxOfSubArrayEndIndex - cur;

            TreeSet<Integer> treeSetToRemove;

            // 현재 수가 홀수
            if (cur % 2 == 1) {
                // 짝수가 지워짐
                if (k % 2 == 0) {
                    treeSetToRemove = evenSet;
                } else {
                    treeSetToRemove = oddSet;
                }
            } else {
                // 홀수가 지워짐
                if (k % 2 == 0) {
                    treeSetToRemove = oddSet;
                } else {
                    treeSetToRemove = evenSet;
                }
            }

            while (!treeSetToRemove.isEmpty()) {
                Integer next = treeSetToRemove.ceiling(minNext);
                if (next == null) {
                    break;
                }

                if (next <= maxNext) {
                    operationCount[next] = operationCount[cur] + 1;
                    visitNumberQueue.add(next);
                    isVisited[next] = true;

                    treeSetToRemove.remove(next);
                } else {
                    break;
                }
            }
        }
        return operationCount;
    }
}