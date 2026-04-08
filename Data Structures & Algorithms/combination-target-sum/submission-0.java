class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        compute(nums, 0, new ArrayList<>(), ans, target);
        return ans;
    }

    public void compute(int[] nums, int i, List<Integer> combi, List<List<Integer>> ans, int target) {
        
        // base case
        if (target == 0) {
            ans.add(new ArrayList<>(combi));
            return;
        }

        if (target < 0 || i >= nums.length) return;

        // include (same index → reuse allowed)
        combi.add(nums[i]);
        compute(nums, i, combi, ans, target - nums[i]);

        // backtrack
        combi.remove(combi.size() - 1);

        // exclude (move to next index)
        compute(nums, i + 1, combi, ans, target);
    }
}