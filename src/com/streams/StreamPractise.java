package com.streams;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Streams - Java Practise.
 *
 * @author - Karthikeyan.
 */
public class StreamPractise {

    public static void main(String []args) {
        printNoOfFruits();
        secondHighestNumber();
        findNonRepeatingCharacter();
        findFirstNonRepeatingChar();
        mergeTwoListAndRemoveDuplicates();
        findFirstLongestString();
        sortObject();
        partitionOddEven();
        batchProcessing();
        splitSingleString();
        reduceMaxMin();
        sumWithInitializer();
    }

    /**
     * Print number of fruits.
     */
    public static void printNoOfFruits() {
       List<String> fruits = Arrays.asList("Apple", "Banana", "Apple");
       System.out.println("***Print number of fruits in map **");
        fruits.stream().
                collect(Collectors.groupingBy(f->f, Collectors.counting())).
                forEach((k,v) -> System.out.println(k +":"+ v));
    }

    /**
     * Second-highest number.
     */
    public static void secondHighestNumber() {
        System.out.println("***Find second highest number **");
        IntStream.rangeClosed(1,10).skip(1).limit(1).boxed().forEach(System.out::println);
    }

    /**
     * Find non-repeating character.
     */
    public static void findNonRepeatingCharacter() {
        System.out.println("**Find non repeating character **");
        String str = "aabbcd";
        str.chars().mapToObj(c -> (char)c).
                //Grouping By - First parameter is key. Second parameter is value.
                collect(Collectors.groupingBy(c->c, Collectors.counting())).
                entrySet().stream().filter(e -> e.getValue() == 1).
                forEach((e) -> System.out.println(e.getKey() + ":" + e.getValue()));
    }

    /**
     * Find first non-repeating characters.
     */
    public static void findFirstNonRepeatingChar() {
        System.out.println("**Find first repeating character **");
        String str = "aabbcd";
        Character output = str.chars().mapToObj(c -> (char)c).
                //Grouping By - First parameter is key. Second parameter is value.
                collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting())).
                entrySet().stream().filter((e) -> e.getValue() == 1).
                findFirst().get().getKey();
        System.out.println(output);
    }

    /**
     * Merge two list and remove duplicates.
     */
    public static void mergeTwoListAndRemoveDuplicates() {
        System.out.println("** Merge two list and remove duplicates **");
        List<String> arr1 = Arrays.asList("kart", "ram", "ragu");
        List<String> arr2 = Arrays.asList("ragu", "kavi");
        Stream.concat(arr1.stream(), arr2.stream()).distinct().forEach(System.out::println);
    }

    /**
     * Find first longest string.
     */
    public static void findFirstLongestString() {
        System.out.println("** Find first longest string **");
        List<String> arr1 = Arrays.asList("karthi", "ramkumar", "rague");
        String longest =
                arr1.stream()
                        .max(Comparator.comparingInt(String::length))
                        .get();
        System.out.println("Longest string: " + longest + " option 1");
        longest = arr1.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(String::length)))
                .get();
        System.out.println("Longest string: " + longest + " option 2");
    }

    /**
     * Sort object
     */
    public static void sortObject() {
        System.out.println("** Sort the object **");
        record Student(String name, int age) {};
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("kart", 15));
        studentList.add(new Student("ram", 5));
        studentList.add(new Student("ragu", 25));
        studentList.add(new Student("kavi", 20));
        studentList.stream().sorted(Comparator.comparing(Student::age).reversed()).forEach(System.out::println);
    }

    /**
     * Partition odd and even.
     */
    public static void partitionOddEven() {
        System.out.println("** Partition odd and even **");
        IntStream.rangeClosed(1,10).boxed().
                //Partition By - First parameter is key (Always Boolean). Second parameter is value.
                collect(Collectors.partitioningBy(x -> x % 2 == 0)).
                forEach((k,v) -> System.out.println(k + ":" + v));
    }

    /**
     * Batch processing.
     */
    public static void batchProcessing() {
        System.out.println("** Batch Processing **");
        List<Integer> ids = IntStream.rangeClosed(1,8).boxed().toList();
        int batchSize = 5;
        AtomicInteger atomic = new AtomicInteger(0);
        Collection<List<Integer>> idCollection = ids.stream().
                //Grouping By - First parameter is key. Second parameter is value.
                collect(Collectors.groupingBy(val -> atomic.getAndIncrement()/batchSize, Collectors.toList())).
                values();
        List<List<Integer>> idList = new ArrayList<>(idCollection);
        idList.forEach(System.out::println);
    }

    /**
     * Split single string.
     */
    public static void splitSingleString() {
        System.out.println("** Split Single String **");
        List<String> strList = List.of("Hi this is karthikeyan", "Stream learning");
        strList.stream().flatMap(s -> Stream.of(s.split(" "))).forEach(System.out::println);
    }

    /**
     * Reduce max min.
     */
    public static void reduceMaxMin() {
        System.out.println("** Reduce max min **");
        int max = IntStream.rangeClosed(1,10).boxed().reduce(Integer::max).get().intValue();
        System.out.println(max);
        int sum = IntStream.rangeClosed(1,10).boxed().reduce(Integer::sum).get().intValue();
        System.out.println(sum);
    }

    /**
     * Sum with initializer.
     */
    public static void sumWithInitializer() {
        System.out.println("** Sum with initializer **");
        int sum = IntStream.rangeClosed(1,3).boxed().reduce(10, (a,b) -> a * b).intValue();
        System.out.println(sum);
    }
}
