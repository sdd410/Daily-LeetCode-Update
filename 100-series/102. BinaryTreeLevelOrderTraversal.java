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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> visitedNode = new LinkedList<>();
        visitedNode.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!visitedNode.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int length = visitedNode.size();
            for (int i = 0; i < length; i++) {
                root = visitedNode.remove();
                if (root != null) {
                    subList.add(root.val);
                    if (root.left != null) visitedNode.add(root.left);
                    if (root.right != null) visitedNode.add(root.right);
                }
            }
            result.add(subList);
        }
        return result;
    }
}