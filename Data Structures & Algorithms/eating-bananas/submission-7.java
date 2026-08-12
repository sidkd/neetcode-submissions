class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 1;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int low = 1;
        int high = maxPile;
        int minSpeed = maxPile;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalHours = 0; // Prevent overflow on time

            for (int pile : piles) {
                totalHours += Math.ceil((double) pile / mid);
            }

            if (totalHours <= h) {
                minSpeed = mid; // This works, record it
                high = mid - 1; // Try to find a slower speed
            } else {
                low = mid + 1; // Too slow, must eat faster
            }
        }

        return minSpeed;
    }
}