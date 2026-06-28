package com.ds.basics.graph;

import java.util.*;

/**
 * Depth First Search.
 *
 * @author Karthikeyan.
 */
public class DFS {

    /**
     * Depth First Search.
     *
     * @param start int
     * @param graph HashMap<Integer, List<Integer>>
     * @return List<Integer>
     */
    public static List<Integer> dfs(int start, Map<Integer, List<Integer>> graph) {
        List<Integer> stack = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        stack.addLast(start);
        while (!stack.isEmpty()) {
            int ele = stack.removeLast();
            if (visited.contains(ele)) {
                continue;
            }
            output.add(ele);
            visited.add(ele);
            List<Integer> nodes = graph.get(ele);
            if(nodes != null) {
                // Iterate in reverse mandatory
                // Since we are using stack, element added at last will be picked up first.
                for(int i=nodes.size()-1; i>=0; i--) {
                    if(!visited.contains(nodes.get(i))) {
                        stack.addLast(nodes.get(i));
                    }
                }
            }
        }
        return output;
    }

    public static void main(String []args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2,3));
        graph.put(2, Arrays.asList(5,6));
        graph.put(3, Arrays.asList(8,9));
        List<Integer> result =  dfs(1, graph);
        result.forEach((ele) -> System.out.print(ele + " "));
    }
}
