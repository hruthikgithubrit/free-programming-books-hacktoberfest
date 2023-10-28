class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        
        // Create a dp array to store the length of the longest subsequence summing up to a particular target sum.
        int[] dp = new int[target + 1];
        
        // Initialize the dp array to a minimum value, except for dp[0] which is set to 0 (an empty subsequence).
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        
        // Iterate through the elements in nums.
        for (int num : nums) {
            // Update the dp array in reverse order to avoid reusing the same number.
            for (int sum = target; sum >= num; sum--) {
                // If dp[sum - num] is not Integer.MIN_VALUE, it means there is a subsequence summing up to sum - num,
                // so we can extend it by adding num to the subsequence.
                if (dp[sum - num] != Integer.MIN_VALUE) {
                    dp[sum] = Math.max(dp[sum], dp[sum - num] + 1);
                }
            }
        }
        
        // The value in dp[target] represents the length of the longest subsequence summing up to target.
        return dp[target] == Integer.MIN_VALUE ? -1 : dp[target];
    }
}
