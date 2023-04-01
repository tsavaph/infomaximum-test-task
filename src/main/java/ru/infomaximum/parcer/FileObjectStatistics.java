package ru.infomaximum.parcer;

import ru.infomaximum.object.FileObject;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FileObjectStatistics {
    private static final String BORDER_LINE = "###################################################################";
    protected List<FileObject> objects;
    protected Stream<FileObject> objectsStream;


    private void printGroupAndTypeDuplicates() {

        System.out.println();
        System.out.println("I. DUPLICATED OBJECTS\n");

        objects.stream()
                .collect(Collectors.groupingBy(x -> x.getGroup() + "~" + x.getType()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((key, value) -> {
                    String[] groupAndType = key.split("~");
                    Integer amount = value.size();
                    System.out.printf("Group - %s, type - %s. Amount - %s%n", groupAndType[0], groupAndType[1], amount);

                    for (FileObject fileObject : value) {
                        System.out.println(fileObject);
                    }

                    System.out.println();
                });

//        objectsStream
//                .collect(Collectors.groupingBy(x -> x.getGroup() + "~" + x.getType()))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue().size() > 1)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
//                .forEach((key, value) -> {
//                    String[] groupAndType = key.split("~");
//                    Integer amount = value.size();
//                    System.out.println(String.format("Duplicate objects with group - \"%s\", type - \"%s\". Amount - %s", groupAndType[0], groupAndType[1], amount));
//
//                    for (FileObject fileObject : value) {
//                        System.out.println(fileObject);
//                    }
//
//                    System.out.println();
//                });

//        Map<String, HashSet<FileObject>> duplicateCounts = new HashMap<>();
//
//        objectsStream.forEach(object -> {
//            String groupPlusType = object.getGroup() + "~" + object.getType();
//
//            HashSet<FileObject> objects = duplicateCounts.get(groupPlusType);
//
//            if (objects == null) {
//                objects = new HashSet<>();
//            }
//
//            objects.add(object);
//            duplicateCounts.put(groupPlusType, objects);
//        });
//
//        System.out.println("22222");
//
//        duplicateCounts.forEach((key, value) -> {
//            String[] groupAndType = key.split("~");
//            int amount = value.size();
//
//            if (amount > 1) {
//
//                System.out.printf("Duplicate objects with group - \"%s\", type - \"%s\". Amount - %s%n", groupAndType[0], groupAndType[1], amount);
//
//                for (FileObject fileObject : value) {
//                    System.out.println(fileObject);
//                }
//
//                System.out.println();
//            }
//        });


    }

//•	Суммарный вес (“weight”) объектов в каждой группе(“group”).
    private void printSumWeight() {
        System.out.println("II. THE TOTAL WEIGHT OF OBJECT IN EACH GROUP\n");
        objects.stream()
                .collect(Collectors.groupingBy(FileObject::getGroup))
                .forEach((key, value) -> {
                    BigInteger totalWeight = BigInteger.ZERO;
                    for (FileObject object : value) {
                        BigInteger bigIntegerValueOfWeight = new BigInteger(String.valueOf(object.getWeight()));
                        totalWeight = totalWeight.add(bigIntegerValueOfWeight);
                    }
                    System.out.printf("Group - %s, weight - %s\n", key, totalWeight);
                });
        System.out.println();
    }
//•	Максимальный и минимальный веса объектов в файле.
    private void printMaxAndMinWeight() {
        System.out.println("III. MAXIMUM AND MINIMUM WEIGHT\n");

        Long minWeight = objects.stream().mapToLong(FileObject::getWeight).min().getAsLong();
        Long maxWeight = objects.stream().mapToLong(FileObject::getWeight).max().getAsLong();

        System.out.printf("Maximum - %d\n", maxWeight);
        System.out.printf("Minimum - %d\n", minWeight);
        System.out.println();
    }

    public void printStatistics() {
        System.out.println(BORDER_LINE);
        System.out.println("SUMMARY STATISTICS");
        System.out.println(BORDER_LINE);
        printGroupAndTypeDuplicates();
        printSumWeight();
        printMaxAndMinWeight();
        System.out.println(BORDER_LINE);
        System.out.println();
    }
}
