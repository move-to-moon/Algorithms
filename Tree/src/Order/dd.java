package Order;

import java.util.*;

public class dd {
}

class Solution {
    List<Integer> list  = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return list;
        System.out.println(list.add(root.val));
        if (root.left != null){
            preorderTraversal(root.left);
        }
        if (root.right != null){
            preorderTraversal(root.right);
        }


        return list;
    }

    public List<Integer> preorderTraversalFor(TreeNode root){
        ArrayList<Integer> list1 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while ( !stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            list1.add(node.val);
            stack.push(root.right);
            stack.push(root.left);
        }
        return list1;

    }

    //迭代的中序遍历

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            Deque<TreeNode> stk = new LinkedList<TreeNode>();
            while (root != null || !stk.isEmpty()) {
                while (root != null) {
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }


}

