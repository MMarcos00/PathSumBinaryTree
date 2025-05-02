package Proyecto.utils;

import Proyecto.model.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Utilidad para construir un árbol binario a partir de un arreglo de enteros.
 * Se utiliza 'null' para representar nodos ausentes.
 */
public class TreeBuilder {

    /**
     * Construye un árbol binario desde un arreglo de enteros donde null representa nodos nulos.
     *
     * @param values arreglo de enteros y nulls que representa un árbol en orden de nivel
     * @return raíz del árbol construido
     */
    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}
