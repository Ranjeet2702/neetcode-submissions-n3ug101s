class Solution {
    public int longestConsecutive(int[] nums) {
        int maxlength = 0;
        HashSet<Integer>set = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        for(int ele : set){
            if(!set.contains(ele - 1)){
                int currentNum = ele;
                int count = 1;
                while(set.contains(currentNum + 1)){
                    currentNum++;
                    count++;
                }
                maxlength = Math.max(maxlength,count);
            }
        }
        return maxlength;
        
    }
}