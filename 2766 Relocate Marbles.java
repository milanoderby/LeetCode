class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> marblePositionSet = new HashSet<>();
        for (int position : nums) {
            marblePositionSet.add(position);
        }

        for (int i = 0; i < moveFrom.length; i++) {
            int src = moveFrom[i];
            int dest = moveTo[i];

            marblePositionSet.remove(src);
            marblePositionSet.add(dest);
        }

        return marblePositionSet.stream().sorted().collect(Collectors.toList());
    }
}