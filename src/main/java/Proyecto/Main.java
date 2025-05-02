package Proyecto;

import Proyecto.model.TreeNode;
import Proyecto.service.PathSumService;
import Proyecto.utils.TreeBuilder;

import java.util.List;

/**
 * Punto de entrada principal de la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        // Árbol: [5,4,8,11,null,13,4,7,2,null,null,5,1]
        Integer[] treeValues = {
                5, 4, 8, 11, null, 13, 4,
                7, 2, null, null, 5, 1
        };
        int targetSum = 22;

        TreeNode root = TreeBuilder.buildTree(treeValues);
        PathSumService service = new PathSumService();
        List<List<Integer>> paths = service.findPaths(root, targetSum);

        System.out.println("Caminos que suman " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}

