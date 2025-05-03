package Proyecto;

import Proyecto.model.TreeNode;
import Proyecto.service.PathSumService;
import Proyecto.utils.TreeBuilder;
import Proyecto.utils.TreePrinter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Árbol construido a partir del carnet 0905-23-5324
        Integer[] treeValues = {
                0, 9, 0, 5, 2, 3, 5, 3, 2, 4
        };

        int targetSum = 14;

        // Construir el árbol
        TreeNode root = TreeBuilder.buildTree(treeValues);

        // Mostrar árbol en ASCII
        System.out.println("Árbol generado (basado en el carnet):");
        TreePrinter.printTree(root);

        // Buscar caminos cuya suma sea igual al targetSum
        PathSumService service = new PathSumService();
        List<List<Integer>> paths = service.findPaths(root, targetSum);

        // Mostrar los caminos encontrados
        System.out.println("\nCaminos desde la raíz hasta hojas que suman " + targetSum + ":");
        if (paths.isEmpty()) {
            System.out.println("No se encontraron caminos.");
        } else {
            for (List<Integer> path : paths) {
                System.out.println(path);
            }
        }
    }
}
