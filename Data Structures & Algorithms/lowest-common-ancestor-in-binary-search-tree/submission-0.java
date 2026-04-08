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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        getpath(root , p, path1);
        getpath(root, q, path2);


        int i = 0;
        for(; i< path1.size() && i< path2.size();i++){
            if(path1.get(i) != path2.get(i))
            break;

        }

        TreeNode lowestCommonAncestor = path1.get(i-1);
        return lowestCommonAncestor;
    }

    public static boolean getpath(TreeNode root , TreeNode n , ArrayList<TreeNode> path){
        if(root == null){
            return false;
        }

        path.add(root);

        if(root.val == n.val){
            return true;
        }
        boolean foundleft = getpath(root.left, n , path);
        boolean foundright = getpath(root.right, n , path);

        if(foundleft || foundright){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}
