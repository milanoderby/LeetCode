class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mappingTable = new HashMap<>();
        Set<Character> selectedAsMappingResult = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char before = s.charAt(i);
            char after = t.charAt(i);

            if (mappingTable.containsKey(before)) {
                Character expectedAfter = mappingTable.get(before);
                if (!expectedAfter.equals(after)) {
                    return false;
                }
            } else {
                if (selectedAsMappingResult.contains(after)) {
                    return false;
                }

                selectedAsMappingResult.add(after);
                mappingTable.put(before, after);
            }
        }
        return true;
    }
}