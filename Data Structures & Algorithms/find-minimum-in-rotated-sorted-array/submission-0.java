
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int min_value = Integer.MAX_VALUE;
        while(left <= right){
            if(nums[left]<=nums[right]){
                min_value = Math.min(min_value,nums[left]);
                break;
            }
            int mid = left + (right - left)/2;
            min_value = Math.min(min_value,nums[mid]);
            if(nums[left]<=nums[mid]){
                min_value = Math.min(min_value,nums[left]);
                left = mid+1;

            }else{
                //min_value = Math.min(min_value,nums[left]);
                right = mid-1;
            }




        }
        return min_value;
    }
}
