package algorithm.tree;

import data_structure.tree.binary.TreeNode;

import java.util.LinkedList;

public class BinaryTreeSerializator {

    public static void main (String[] args) {
        BinaryTreeSerializator serializator = new BinaryTreeSerializator();
        String treeSample = "[1,2,3,n,n,4,5]";
       /*
            1
           / \
          2   3
             / \
            4   5
        */
        System.out.println(serializator.serialize(serializator.deserialize(treeSample)));
    }

    public String serialize(TreeNode root) {
        if (root == null) return "";
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curNode;
        StringBuilder sb = new StringBuilder();
        int levelSize;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                curNode = queue.poll();
                if (curNode == null) {
                    sb.append('n');
                    sb.append(',');
                    continue;
                }
                sb.append(curNode.val);
                sb.append(',');
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
        }
        if (sb.lastIndexOf(",") == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.insert(0, '[');
        sb.append(']');
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] elements = data.substring(1, data.length() - 1).split(",");
        if (elements.length == 0) {
            return null;
        }

        TreeNode root = parse(elements[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int n = elements.length;
        TreeNode parent;
        for (int i = 1; i < n; i++) {
            parent = queue.poll();
            parent.left = parse(elements[i]);
            if (parent.left != null) {
                queue.add(parent.left);
            }
            parent.right = parse(elements[++i]);
            if (parent.right != null) {
                queue.add(parent.right);
            }
        }
        return root;
    }

    private TreeNode parse(String element) {
        if (element.equals("n")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(element));
    }
}
