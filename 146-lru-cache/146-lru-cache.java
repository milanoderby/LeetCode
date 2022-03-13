class LRUCache {

    private int capacity;
        private Map<Integer, Integer> cacheMap;
        private Queue<Integer> usedKeyHistory;
        private int[] countOfUsedKey;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cacheMap = new HashMap<>();
            this.usedKeyHistory = new ArrayDeque<>();
            this.countOfUsedKey = new int[10001];
            for (int i = 0; i < 10001; i++) {
                this.countOfUsedKey[i] = 0;
            }
        }

        public int get(int key) {
            if (cacheMap.containsKey(key)) {
                usedKeyHistory.add(key);
                countOfUsedKey[key]++;
            }
            return cacheMap.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            cacheMap.put(key, value);
            usedKeyHistory.add(key);
            countOfUsedKey[key]++;

            if (cacheMap.size() > capacity) {
                int lruKey = usedKeyHistory.poll();
                countOfUsedKey[lruKey]--;
                while (countOfUsedKey[lruKey] > 0) {
                    lruKey = usedKeyHistory.poll();
                    countOfUsedKey[lruKey]--;
                }
                cacheMap.remove(lruKey);
            }
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */