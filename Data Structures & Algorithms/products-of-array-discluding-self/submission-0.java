class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] prefixproduct = new int [n];
        int [] suffixproduct = new int [n];
        int [] ans = new int [n];
        prefixproduct[0] = 1;
        for(int i = 1; i < n; i++){
            prefixproduct[i] = prefixproduct[i-1] * nums[i-1];
        }
        suffixproduct[n-1] = 1;
        for(int j = n-2; j>=0; j--){
            suffixproduct[j] = suffixproduct[j+1] * nums[j+1];
        }
        for(int i = 0; i < n; i++){
            ans[i] = prefixproduct[i] * suffixproduct[i];
        }
        return ans;

    }
}  
