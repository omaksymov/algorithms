package algorithm.tree;

import data_structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Breadth-first search (bfs) tree traversal.
 * BFS according to its name is intended to "search" specific element in specific order of traversal
 * (first - neighbours of the current node, then their children).
 * Its second commonly used property for the trees is level-order traversal.
 * Slight modification of this algorithm is required to obtain list of levels - see {@link BinaryTreeLevels}
 */
public class BFSBinaryTreeTraversal {
    public List<Integer> bfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curNode;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            res.add(curNode.val);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeSerializer serializer = new BinaryTreeSerializer();
        String treeSample = "[1,2,4,null,3,5,6]";
       /*
            1__
           /    \
          2      4
           \    / \
            3  5   6
            Expected output: [1,2,4,3,5,6]
        */
        BFSBinaryTreeTraversal sol = new BFSBinaryTreeTraversal();
        List<Integer> res = sol.bfs(serializer.deserialize(treeSample));
        System.out.println(res.toString());
    }
}
