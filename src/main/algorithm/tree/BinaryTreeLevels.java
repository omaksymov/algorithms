package algorithm.tree;

import data_structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is slight modification of BFS (level-order traversal) for cases when we have to split nodes by levels.
 */
public class BinaryTreeLevels {
    public List<List<Integer>> levels(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curNode;
        List<Integer> level;
        int levelSize;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            level = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                curNode = queue.poll();
                level.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeSerializator serializator = new BinaryTreeSerializator();
        String treeSample = "[1,2,4,n,3,5,6]";
       /*
            1__
           /    \
          2      4
           \    / \
            3  5   6
            Expected output: [[1],[2,4],[3,5,6]]
        */
        BinaryTreeLevels sol = new BinaryTreeLevels();
        List<List<Integer>> res = sol.levels(serializator.deserialize(treeSample));
        System.out.println(res.toString());
    }
}
