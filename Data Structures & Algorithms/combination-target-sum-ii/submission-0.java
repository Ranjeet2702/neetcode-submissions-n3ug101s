

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // ✅ Must sort first
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();
        solve(candidates, 0, target, ans, combin);
        return ans;
    }

    public  void solve(int[] candidates, int idx, int target,
                       List<List<Integer>> ans, List<Integer> combin) {

        if (target == 0) {
            ans.add(new ArrayList<>(combin));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            // ✅ Skip duplicates at same recursion level
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            // ✅ Pruning: no need to go further
            if (candidates[i] > target) break;

            combin.add(candidates[i]);
            solve(candidates, i + 1, target - candidates[i], ans, combin); // i+1 = each element once
            combin.remove(combin.size() - 1);
        }
    }
}