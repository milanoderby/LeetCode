class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumOfGas = 0, sumOfCost = 0;
        int[] extraGas = new int[gas.length];

        for (int i = 0; i < gas.length; i++) {
            sumOfGas += gas[i];
            sumOfCost += cost[i];

            extraGas[i] = gas[i] - cost[i];
        }

        if (sumOfGas < sumOfCost) {
            return -1;
        }

        int sumOfExtraGas = 0;
        int indexOfMinimumSumOfExtraGas = 0;
        int minimumSumOfExtraGas = Integer.MAX_VALUE;

        for (int i = 0; i < gas.length; i++) {
            sumOfExtraGas += extraGas[i];
            if (minimumSumOfExtraGas > sumOfExtraGas) {
                minimumSumOfExtraGas = sumOfExtraGas;
                indexOfMinimumSumOfExtraGas = i;
            }
        }
        
        return (indexOfMinimumSumOfExtraGas + 1) % gas.length;
    }
}