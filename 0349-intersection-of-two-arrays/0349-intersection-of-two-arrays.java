class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setA = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> setB = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        setA.retainAll(setB);
        return setA.stream().mapToInt(Integer::intValue).toArray();
    }
}