/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<Integer>();
        Stack<TreeNode> father = new Stack<TreeNode>();
        TreeNode left=null;
        while(root != null){
            if(root.left!=null){
                left=root.left;
                root.left=null;
                father.push(root);
                root=left;
            }else{
                inOrder.add(root.val);
                if(root.right!=null)
                    root=root.right;
                else if(father.isEmpty())
                    root=null;
                else root=father.pop();
            }
        }
        
        return inOrder;
        
    }
}