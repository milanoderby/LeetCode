class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidStack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean mustPushAsteroid = true;
            while (!asteroidStack.isEmpty()) {
                int prevAsteroid = asteroidStack.peek();
                if (prevAsteroid > 0 && asteroid < 0) {
                    if (Math.abs(prevAsteroid) > Math.abs(asteroid)) {
                        mustPushAsteroid = false;
                        break;
                    } else if (Math.abs(prevAsteroid) == Math.abs(asteroid)) {
                        asteroidStack.pop();
                        mustPushAsteroid = false;
                        break;
                    } else {
                        asteroidStack.pop();
                    }
                } else {
                    break;
                }
            }

            if (mustPushAsteroid) {
                asteroidStack.push(asteroid);
            }
        }

        return asteroidStack.stream().mapToInt(Integer::intValue).toArray();
    }
}