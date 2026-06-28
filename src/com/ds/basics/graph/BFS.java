package com.ds.basics.graph;

import java.util.*;

/**
 * Breath First Search.
 *
 * @author Karthikeyan.
 */
public class BFS {

    /**
     * Breath First Search.
     *
     * @param start int
     * @param graph HashMap<Integer, List<Integer>>
     * @return List<Integer>
     */
    public static List<Integer> bfs(int start, Map<Integer, List<Integer>> graph) {
        List<Integer> queue = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        queue.addLast(start);
        while (!queue.isEmpty()) {
            int ele = queue.removeFirst();
            if (visited.contains(ele)) {
                continue;
            }
            result.add(ele);
            visited.add(ele);
            List<Integer> nodes = graph.get(ele);
            if(nodes != null) {
                for (Integer node : nodes) {
                    if (!visited.contains(node)) {
                        queue.addLast(node);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String []args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2,3));
        graph.put(2, Arrays.asList(5,6));
        graph.put(3, Arrays.asList(8,9));
        List<Integer> result =  bfs(1, graph);
        result.forEach((ele) -> System.out.print(ele + " "));
    }
}
