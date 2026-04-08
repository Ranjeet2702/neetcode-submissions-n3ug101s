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
    int preIdx =0; // why function ke ander direct 0 kyu nhi use kiye
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
        return helper(preorder,inorder,0,inorder.length-1);
        
    }
    
    public TreeNode helper(int [] preorder, int[] inorder,int left, int right){
        if(left > right){
            return null;
        }
        // Step 1: Root from preorder
        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;
        // Step 2: Find in inorder
        int inIdx = search(inorder,left,right,root.val);
        // Step 3: Build left & right
        root.left = helper(preorder,inorder,left,inIdx-1);
        root.right = helper(preorder,inorder,inIdx+1, right);
        return root;
        
    }
    public int search(int[]inorder,int left,int right,int val){
        for(int i = left; i<=right; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }


}