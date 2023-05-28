class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int[] original = new int[derived.length];
        original[0] = 0;
        for (int i = 1; i < original.length; i++) {
            original[i] = original[i - 1] ^ derived[i - 1];
        }

        if (derived[original.length - 1] == (original[0] ^ original[original.length - 1])) {
            return true;
        }
        return false;
    }
}