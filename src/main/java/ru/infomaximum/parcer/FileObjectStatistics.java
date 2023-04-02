package ru.infomaximum.parcer;

import ru.infomaximum.object.FileObject;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public abstract class FileObjectStatistics {
    private static final String BORDER_LINE = "###################################################################";
    protected List<FileObject> objects;


    private void printGroupAndTypeDuplicates() {

        System.out.println();
        System.out.println("I. DUPLICATED OBJECTS\n");

        objects.stream()
                .collect(Collectors.groupingBy(x -> x.getGroup() + "~" + x.getType(), Collectors.toList()))
                .forEach((key, value) -> {
                    if (value.size() > 1) {
                        String[] groupAndType = key.split("~");
                        int amount = value.size();
                        System.out.printf("Group - %s, type - %s. Amount - %s%n", groupAndType[0], groupAndType[1], amount);

                        value.forEach(System.out::println);

                        System.out.println();
                    }
                });
    }

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

    private void printMaxAndMinWeight() {
        System.out.println("III. MAXIMUM AND MINIMUM WEIGHT\n");

        long minWeight = objects.stream().mapToLong(FileObject::getWeight).min().getAsLong();
        long maxWeight = objects.stream().mapToLong(FileObject::getWeight).max().getAsLong();

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
