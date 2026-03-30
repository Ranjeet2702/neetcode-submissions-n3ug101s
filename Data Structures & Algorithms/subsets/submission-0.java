class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        List<List<Integer>>current = new ArrayList<>();
        Possiblesubset(nums,ans,new ArrayList<>(),0);
        return ans;
        
    }
    public void Possiblesubset(int [] nums, List<List<Integer>>ans, List<Integer>current, int idx){
        // base case
        
        if(idx== nums.length){
             ans.add(new ArrayList<>(current));
             return;
        }
        current.add(nums[idx]);
        Possiblesubset(nums,ans, current,idx+1);
        current.remove(current.size()-1);
        Possiblesubset(nums,ans, current,idx+1);
    }
}