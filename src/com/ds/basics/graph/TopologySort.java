package com.ds.basics.graph;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Topology Sort using Kahn’s Algorithm.
 *
 * @author Karthikeyan.
 */
public class TopologySort {

    /**
     * Topology Sort
     *
     * @param graph Map<Integer, List<Integer>>
     * @return List<Integer>
     */
    public static List<Integer> topologySort(Map<Integer, List<Integer>> graph) {
        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> indegrees = calculateIndegrees(graph);
        List<Integer> queue = indegrees.keySet().stream().
                filter(e -> indegrees.get(e) == 0).
                collect(Collectors.toCollection(ArrayList::new));
        // Progress BFS.
        while(!queue.isEmpty()) {
            int ele = queue.removeFirst();
            output.add(ele);
            List<Integer> children =  graph.get(ele);
            if(children != null) {
                for (Integer child : children) {
                    indegrees.put(child, indegrees.get(child) - 1);
                    if (indegrees.get(child) == 0) {
                        queue.addLast(child);
                    }
                }
            }
        }
        return output;
    }

    /**
     * Calculate indegrees.
     *
     * @param graph Map<Integer, Integer>
     * @return Map<Integer, Integer>
     */
    public static Map<Integer, Integer> calculateIndegrees(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> indegrees = new HashMap<>();
        graph.keySet().forEach((key) -> {calculateIndegrees(key, graph.get(key), indegrees);});
        return indegrees;
    }

    // Important step.
    public static void calculateIndegrees(Integer parent, List<Integer> children, Map<Integer, Integer> indegrees) {
        // Parent should initialized to 0.
        indegrees.putIfAbsent(parent, 0);
        for(int child : children) {
            // Child should start from 1.
            indegrees.put(child, indegrees.getOrDefault(child, 0) + 1);
        }
    }

    public static void main(String []args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1));
        graph.put(4, Arrays.asList(5));
        graph.put(1, Arrays.asList(2));
        graph.put(5, Arrays.asList(2,1));
        graph.put(2, Arrays.asList(3));
        topologySort(graph).forEach((ele) -> System.out.print(ele + " "));
    }
}
