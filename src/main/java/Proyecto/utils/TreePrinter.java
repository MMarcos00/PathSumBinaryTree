package Proyecto.utils;

import Proyecto.model.TreeNode;

public class TreePrinter {

    public static void printTree(TreeNode root) {
        printTree(root, "", true);
    }

    private static void printTree(TreeNode node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.val);
        if (node.left != null || node.right != null) {
            if (node.right != null)
                printTree(node.right, prefix + (isTail ? "    " : "│   "), node.left == null);
            if (node.left != null)
                printTree(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }
}
