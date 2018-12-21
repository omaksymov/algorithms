package algorithm.tree;

import data_structure.tree.binary.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Pre-order iterative traversal of binary tree.
 */
public class PreOrderIterativeTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curNode;
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            result.add(curNode.val);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeSerializator serializator = new BinaryTreeSerializator();
        String treeSample = "[1,2,3,n,n,4,5]";
       /*
            1
           / \
          2   3
             / \
            4   5
        */
        PreOrderIterativeTraversal sol = new PreOrderIterativeTraversal();
        List<Integer> res = sol.preorderTraversal(serializator.deserialize(treeSample));
        System.out.println(res.toString());
    }
}
