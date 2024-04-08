class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] countOfStudentWhoWantSandwich = new int[2];
        for (int sandwichWhichStudentWants : students) {
            countOfStudentWhoWantSandwich[sandwichWhichStudentWants]++;
        }

        Stack<Integer> sandwichStack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }
        
        while (!sandwichStack.isEmpty()) {
            int topSandwich = sandwichStack.peek();
            if (countOfStudentWhoWantSandwich[topSandwich] <= 0) {
                break;
            }

            sandwichStack.pop();
            countOfStudentWhoWantSandwich[topSandwich]--;
        }
        return sandwichStack.size();
    }
}