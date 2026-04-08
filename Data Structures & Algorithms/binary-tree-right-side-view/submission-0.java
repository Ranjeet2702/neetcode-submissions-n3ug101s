/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer>nums = new ArrayList<>();
        helper(root,0,nums);
        return nums;
        

    }
    public void helper(TreeNode root,int level, ArrayList<Integer>nums){
        if(root  == null){
            return;
        }
        if(level == nums.size()){
            nums.add(root.val);
        }
        helper(root.right, level+1,nums);
        helper(root.left,level+1,nums);
        

    }
}
