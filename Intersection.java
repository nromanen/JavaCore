package Lesson6;
import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersection {

    private static Rectangle CollectionUtils;

    public static void main(String[] args) {

        Set<Integer> Set1 = new HashSet<>(Arrays.asList(1, 3, 5, 7));
        Set<Integer> Set2 = new HashSet<>(Arrays.asList(2, 4, 6, 8));

        Set<Integer> union = new HashSet<>(Set1);
        union.addAll(Set2);
        System.out.println("Set1 union Set2 : " + union);

        Set<Integer> intersection = new HashSet<>(Set1);
        intersection.retainAll(Set2);
        System.out.println("Set1 intersection Set2 : " + intersection);

// !!! Version 2 !!! //

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4));
        Set<Integer> union2 = new HashSet<>();
        union2.addAll(setA);
        union2.addAll(setB);

        Set<Integer> intersection2 = setA.parallelStream()
                .filter(setB::contains)
                .collect(Collectors.toSet());

        System.out.println("SetA Union SetB : " + union2);
        System.out.println("SetA Intersection SetB : " + intersection2);


    }
}



