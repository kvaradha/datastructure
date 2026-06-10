package com.ds.dp;

public class KnapSack {

    public static int knapSack(int []weights, int []values, int capacity) {

        int [][]dp = new int[capacity + 1][weights.length + 1];
        // Loop through capacities
        for (int i = 1; i <= capacity; i++) {
            // Loop through items (FIX: changed to <= to include the last item)
            for (int j = 1; j <= weights.length; j++) {

                // Current item's weight and value are at index j-1
                int currentWeight = weights[j - 1];
                int currentValue = values[j - 1];

                // FIX: Check if the item can actually fit in the current capacity 'i'
                if (currentWeight <= i) {
                    // Remaining capacity if we take this item
                    int remainingCap = i - currentWeight;

                    // Max of (Exclude item [same capacity, previous item], Include item)
                    dp[i][j] = Math.max(dp[i][j - 1], currentValue + dp[remainingCap][j - 1]);
                } else {
                    // Item is too heavy, carry over the value from the previous item
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[capacity][weights.length];
    }

    public static void main(String []args) {

        // Arrays are guaranteed to have the same length
        int[] weights = {2, 3, 4, 5};
        int[] values = {10, 20, 30, 40};
        // Max weight
        int capacity = 5;
        int n = weights.length;

        int maxProfit = knapSack(weights, values, capacity);
        System.out.println("Maximum Value: " + maxProfit);

    }
}
