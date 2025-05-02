package service;

import Proyecto.model.TreeNode;
import Proyecto.service.PathSumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Proyecto.utils.TreeBuilder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pruebas unitarias para PathSumService.
 */
class PathSumServiceTest {

    private PathSumService pathSumService;

    @BeforeEach
    void setUp() {
        pathSumService = new PathSumService();
    }

    @Test
    void testFindPaths_targetSum22_returnsCorrectPaths() {
        Integer[] tree = {
                5, 4, 8, 11, null, 13, 4,
                7, 2, null, null, 5, 1
        };
        TreeNode root = TreeBuilder.buildTree(tree);
        int targetSum = 22;

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(5, 4, 11, 2),
                Arrays.asList(5, 8, 4, 5)
        );

        List<List<Integer>> actual = pathSumService.findPaths(root, targetSum);

        assertEquals(expected, actual);
    }

    @Test
    void testFindPaths_emptyTree_returnsEmptyList() {
        TreeNode root = null;
        List<List<Integer>> actual = pathSumService.findPaths(root, 10);
        assertEquals(0, actual.size());
    }

    @Test
    void testFindPaths_noMatchingPath_returnsEmptyList() {
        Integer[] tree = {1, 2, 3};
        TreeNode root = TreeBuilder.buildTree(tree);
        int targetSum = 100;
        List<List<Integer>> actual = pathSumService.findPaths(root, targetSum);
        assertEquals(0, actual.size());
    }

    @Test
    void testFindPaths_singleNode_matchingTarget() {
        Integer[] tree = {5};
        TreeNode root = TreeBuilder.buildTree(tree);
        List<List<Integer>> actual = pathSumService.findPaths(root, 5);
        List<List<Integer>> expected = List.of(List.of(5));
        assertEquals(expected, actual);
    }
}

