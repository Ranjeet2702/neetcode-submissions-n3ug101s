

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        findPermutation(list, new ArrayList<>(), ans);
        return ans;
    }

    public void findPermutation(ArrayList<Integer> nums, ArrayList<Integer> curr, List<List<Integer>> ans) {
        
        // base case
        if (nums.size() == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // recursion
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);

            // remove element
            nums.remove(i);

            // choose
            curr.add(val);

            // explore
            findPermutation(nums, curr, ans);

            // backtrack
            curr.remove(curr.size() - 1);
            nums.add(i, val); // important: restore at same index
        }
    }
}