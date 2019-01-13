package algorithm.tree;

import data_structure.tree.binary.TreeNode;

import java.util.LinkedList;

public class BinaryTreeSerializer {
    private static final String NULL = "null";
    private static final Character DELIMITER = ',';

    /**
     * Encodes a tree to a single string.
     * Example:
     *          1
     *         / \
     *        2   3
     *           / \
     *          4  5
     * is represented as "[1,2,3,null,null,4,5]"
     * @return String in the form "[1,2,null,3]" where values are TreeNode values.
     */
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curNode;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int levelSize;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                curNode = queue.poll();
                if (curNode == null) {
                    if (i != levelSize - 1) {
                        sb.append(NULL);
                        sb.append(DELIMITER);
                    }
                    continue;
                }
                sb.append(curNode.val);
                sb.append(DELIMITER);
                if (!isLeaf(curNode)
                        || (!queue.isEmpty()
                            && queue.peek() != null
                            && !isLeaf(queue.peek()))) {
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                }
            }
        }
        if (sb.lastIndexOf(String.valueOf(DELIMITER)) == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(']');
        return sb.toString();
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    /**
     * Decodes your encoded data to tree.
     *
     * Example:
     * "[1,2,3,null,4,5]" represents the following tree:
     *            1
     *          /  \
     *         2    3
     *         \   /
     *         4  5
     *
     * @param data String in the form "[1,2,null,3]" representing binary tree serialized with {@link #serialize(TreeNode)}.
     */
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String str = data.trim();
        if (str.length() < 3) return null;
        str = str.substring(1, str.length() - 1);
        String[] elements = str.split(String.valueOf(DELIMITER));
        if (elements.length == 0) {
            return null;
        }

        TreeNode root = parse(elements, 0);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int n = elements.length;
        TreeNode parent;
        for (int i = 1; i < n; i++) {
            parent = queue.poll();
            parent.left = parse(elements, i);
            if (parent.left != null) {
                queue.add(parent.left);
            }
            parent.right = parse(elements, ++i);
            if (parent.right != null) {
                queue.add(parent.right);
            }
        }
        return root;
    }

    private TreeNode parse(String[] elements, int i) {
        String element;
        if (i >= elements.length) {
            element = NULL;
        } else {
            element = elements[i];
        }
        if (element.equals(NULL)) {
            return null;
        }
        return new TreeNode(Integer.valueOf(element));
    }
}
