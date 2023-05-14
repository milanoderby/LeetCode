class FrequencyTracker {

    // 숫자를 key로 하고, 숫자가 나오는 빈도수를 value로 하는 Map
    private Map<Integer, Integer> numberFrequencyMap = new HashMap<>();
    // 빈도수를 key로 하고, 빈도수를 가지는 숫자의 개수를 value로 하는 Map
    private Map<Integer, Integer> frequencyCountMap = new HashMap<>();

    public FrequencyTracker() {
        numberFrequencyMap = new HashMap<>();
        frequencyCountMap = new HashMap<>();
    }

    public void add(int number) {
        int frequency = numberFrequencyMap.getOrDefault(number, 0);
        numberFrequencyMap.put(number, frequency + 1);

        int countOfNumber = frequencyCountMap.getOrDefault(frequency, 0);
        frequencyCountMap.put(frequency, countOfNumber - 1);

        countOfNumber = frequencyCountMap.getOrDefault(frequency + 1, 0);
        frequencyCountMap.put(frequency + 1, countOfNumber + 1);
    }

    public void deleteOne(int number) {
        int frequency = numberFrequencyMap.getOrDefault(number, 0);
        // 이미 존재하지 않는 숫자를 제거하려는 경우
        if (frequency == 0) {
            return;
        }
        numberFrequencyMap.put(number, frequency - 1);

        int countOfNumber = frequencyCountMap.getOrDefault(frequency, 0);
        frequencyCountMap.put(frequency, countOfNumber - 1);

        countOfNumber = frequencyCountMap.getOrDefault(frequency - 1, 0);
        frequencyCountMap.put(frequency - 1, countOfNumber + 1);
    }

    public boolean hasFrequency(int frequency) {
        return frequencyCountMap.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */