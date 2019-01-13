package algorithm.tree;

import data_structure.tree.binary.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Post-order iterative traversal of binary tree.
 */
public class PostOrderIterativeTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        twoStacksSolution(root, result);
        return result;
    }

    /**
     * Idea is similar to {@link PreOrderIterativeTraversal}, but in reverse order. To achieve that - need 2 stacks.
     */
    private void twoStacksSolution(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode curNode;
        while (!stack1.empty()) {
            curNode = stack1.pop();
            stack2.push(curNode);
            if (curNode.left != null) {
                stack1.push(curNode.left);
            }
            if (curNode.right != null) {
                stack1.push(curNode.right);
            }
        }
        while (!stack2.empty()) {
            result.add(stack2.pop().val);
        }
    }

    /**
     * Much harder single-stack solution, see inlined comments for details.
     */
    private void singleStackSolution(TreeNode root, List<Integer> result) {
        TreeNode prevNode = null, curNode;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            curNode = stack.peek();
            // conditions meaning traversing down the tree
            if (prevNode == null || prevNode.left == curNode || prevNode.right == curNode) {
                if (curNode.left != null) {
                    stack.push(curNode.left);
                } else if (curNode.right != null) {
                    stack.push(curNode.right);
                } else {
                    result.add(curNode.val);
                    stack.pop();
                }
            } else { // traversing up the tree
                // from left child to parent and present right child
                if (curNode.left == prevNode && curNode.right != null) {
                    stack.push(curNode.right);
                } else { // from right child to parent or no right parent when from left child to parent
                    result.add(curNode.val);
                    stack.pop();
                }
            }
            // helps to know if top-down or bottom-up traversal will be on the next step
            prevNode = curNode;
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

          Expected output: [2,4,5,3,1]
        */
        PostOrderIterativeTraversal sol = new PostOrderIterativeTraversal();
        List<Integer> res = sol.postorderTraversal(serializer.deserialize(treeSample));
        System.out.println(res.toString());
    }
}
