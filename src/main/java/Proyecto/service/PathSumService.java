package Proyecto.service;

import Proyecto.model.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que encuentra todas las rutas desde la raíz hasta las hojas donde
 * la suma de los nodos sea igual a targetSum.
 */
public class PathSumService {

    /**
     * Retorna todas las rutas de raíz a hoja donde la suma sea igual a targetSum.
     *
     * @param root      nodo raíz del árbol binario
     * @param targetSum suma objetivo
     * @return lista de rutas válidas
     */
    public List<List<Integer>> findPaths(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    /**
     * Método auxiliar que realiza la búsqueda en profundidad (DFS) y construye las rutas.
     */
    private void backtrack(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);
        remainingSum -= node.val;

        // Si es hoja y la suma coincide, guardar copia de la ruta
        if (node.left == null && node.right == null && remainingSum == 0) {
            result.add(new ArrayList<>(path));
        } else {
            backtrack(node.left, remainingSum, path, result);
            backtrack(node.right, remainingSum, path, result);
        }

        // Backtrack: eliminar último nodo para explorar otros caminos
        path.remove(path.size() - 1);
    }
}
