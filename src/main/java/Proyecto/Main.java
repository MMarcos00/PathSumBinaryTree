package Proyecto;

import Proyecto.model.TreeNode;
import Proyecto.service.PathSumService;
import Proyecto.utils.TreeBuilder;
import Proyecto.utils.TreePrinter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] treeValues = {
                0, 9, 0, 5, 2, 3, 5, 3, 2, 4
        };

        int targetSum = 14;

        TreeNode root = TreeBuilder.buildTree(treeValues);

        // Imprimir el árbol en forma gráfica
        System.out.println("Árbol generado:");
        TreePrinter.printTree(root);

        // Buscar caminos con suma deseada
        PathSumService service = new PathSumService();
        List<List<Integer>> paths = service.findPaths(root, targetSum);

        System.out.println("\nCaminos que suman " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
