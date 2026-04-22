class Solution {
    public int climbStairs(int n) {
        int[]dp = new int[n+1];
        return countways(n,dp);
    }
    public int countways(int n, int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = countways(n-1,dp)+countways(n-2,dp);
        return dp[n];
    }
}
