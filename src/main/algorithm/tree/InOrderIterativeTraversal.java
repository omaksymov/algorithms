package algorithm.tree;

import data_structure.tree.binary.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * In-order iterative traversal of binary tree.
 */
public class InOrderIterativeTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        processLeftUntilStuck(root, stack);
        TreeNode curNode;
        while (!stack.empty()) {
            curNode = stack.pop();
            result.add(curNode.val);
            processLeftUntilStuck(curNode.right, stack);
        }
        return result;
    }

    private void processLeftUntilStuck(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String treeSample = "[1,2,3,null,null,4,5]";
       /*
            1
           / \
          2   3
             / \
            4   5

         Expected output: [2,1,4,3,5]
        */
        InOrderIterativeTraversal sol = new InOrderIterativeTraversal();
        List<Integer> res = sol.inorderTraversal(serializer.deserialize(treeSample));
        System.out.println(res.toString());
    }
}
