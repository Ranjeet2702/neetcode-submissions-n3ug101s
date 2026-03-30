class Solution {
    public int maxArea(int[] heights) {
        int max_water = 0;
        int left = 0;
        int right = heights.length - 1;
        while(left < right){
            int ht = Math.min(heights[left],heights[right]);
            int lenght = (right - left);
            int current_water = (ht * lenght);
            max_water = Math.max(max_water,current_water);
            if(heights[left] < heights[right]){
                left++;

            }else{
                right--;
            }

        }
        return max_water;
    }
}
