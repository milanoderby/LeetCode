class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> setA = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> setB = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        setA.retainAll(setB);
        return setA.stream().min(Comparator.naturalOrder()).orElse(-1);
    }
}