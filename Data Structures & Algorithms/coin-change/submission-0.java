class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int [] dp = new int [amount +1];
        for(int i =0; i<=amount; i++){
            dp[i] = max;

        }
        dp[0] = 0;
        for(int i =1; i<=amount; i++){
            for(int coin : coins){
                if(coin<=i && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                } 
            }
        }
        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dp[amount];
        }
    }
}
