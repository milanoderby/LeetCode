class Solution {
    public boolean isHappy(int n) {
        Set<Integer> repeatedNumbers = new HashSet<>();
        while (true) {
            if (n == 1) {
                return true;
            }

            if (repeatedNumbers.contains(n)) {
                return false;
            }
            repeatedNumbers.add(n);

            n = getSumOfTheSquareOfDigits(n);
        }
    }
    
    public int getSumOfTheSquareOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }
}