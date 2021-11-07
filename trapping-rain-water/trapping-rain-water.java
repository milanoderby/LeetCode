class Solution {
    public int trap(int[] height) {
        int totalWater = 0;

        Stack<Water> waterStack = new Stack<>();
        int index = 0;
        for ( ; index < height.length; index++) {
            if (height[index] > 0) {
                waterStack.push(new Water(index, height[index]));
                index++;
                break;
            }
        }

        for ( ; index < height.length; index++) {
            int rightHeight = height[index];



            while (!waterStack.isEmpty()) {
                Water current = waterStack.peek();
                if (current.height > rightHeight) {
                    waterStack.push(new Water(index, rightHeight));
                    break;
                } else if (current.height == rightHeight) {
                    waterStack.pop();
                    waterStack.push(new Water(index, rightHeight));
                    break;
                } else {
                    waterStack.pop();
                    if (waterStack.isEmpty()) {
                        waterStack.push(new Water(index, rightHeight));
                        break;
                    }

                    Water left = waterStack.peek();
                    totalWater += (Math.min(left.height, rightHeight) - current.height) * (index - left.index - 1);
                }
            }

            if (waterStack.isEmpty()) {
                waterStack.push(new Water(index, 0));
            }
        }

        return totalWater;
    }
    
    private static class Water {
        int index;
        int height;

        public Water(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}