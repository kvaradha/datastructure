package com.ds.basics.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Code No: 207 - Course Schedule
 *
 * @author Karthikeyan
 */
public class CourseSchedule {

    /**
     * Course Schedule
     *
     * @param preq int[][]
     * @param noOfCourses int
     */
    public static boolean courseSchedule(int [][]preq, int noOfCourses) {
        Map<Integer, ArrayList<Integer>> graph = buildGraph(preq, noOfCourses);
        Map<Integer, Integer> indegree = createIndegree(graph);
        // Perform BFS.
        List<Integer> output = new ArrayList<>();
        List<Integer> queue = indegree.keySet().stream().
                filter((key) -> indegree.get(key) == 0).
                collect(Collectors.toCollection(ArrayList::new));
        while (!queue.isEmpty()) {
            int ele = queue.removeFirst();
            output.add(ele);
            List<Integer> children = graph.get(ele);
            if(children != null) {
                for(int child : children) {
                    indegree.put(child, indegree.get(child) - 1);
                    if(indegree.get(child) == 0) {
                        queue.addLast(child);
                    }
                }
            }
        }
        return output.size() == noOfCourses;
    }

    public static Map<Integer, Integer> createIndegree(Map<Integer, ArrayList<Integer>> graph) {
        Map<Integer, Integer> indegree = new HashMap<>();
        graph.forEach((e, v) -> createIndegree(e,v,indegree));
        return indegree;
    }

    public static void createIndegree(int parent, List<Integer> child, Map<Integer, Integer> indegree) {
        indegree.putIfAbsent(parent, 0);
        for(int ele: child) {
            indegree.put(ele, indegree.getOrDefault(ele,0) + 1);
        }
    }

    public static Map<Integer, ArrayList<Integer>> buildGraph(int [][]preq, int n) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int []p : preq) {
           int dest = p[0];
           int src = p[1];
           if(map.get(src) == null) {
               List<Integer> child = new ArrayList<>();
               child.add(dest);
               map.put(src, new ArrayList<>(child));
           } else {
               map.get(src).add(dest);
           }
        }
        return map;
    }

    public static void main(String []args) {
        int [][]prerequisites  = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numOfCourses = 4;
        System.out.println(courseSchedule(prerequisites, numOfCourses));
        prerequisites = new int[][] {{1,0}, {0,1}};
        numOfCourses = 2;
        System.out.println(courseSchedule(prerequisites, numOfCourses));
    }
}
