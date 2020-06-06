import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Set<Integer> set1 = new HashSet<>();
//        set1.add(0);
//        set1.add(1);
//        set1.add(2);
//        set1.add(3);
//        set1.add(4);
//        set1.add(5);
//        Set<Integer> set2 = new HashSet<>();
//        set2.add(2);
//        set2.add(3);
//        set2.add(4);
//        set2.add(5);
//        set2.add(6);
//        set2.add(7);
//        set2.add(8);
//
//        System.out.println(union(set1, set2));
//        System.out.println(intersect(set1, set2));
//
//        Map<String, String> personMap = new HashMap<>();
//        personMap.put("Geits", "Feri");
//        personMap.put("Jeferson", "Stas");
//        personMap.put("Voznjak", "Stiv");
//        personMap.put("Jacksom", "Mikel");
//        personMap.put("Bush", "Stas");
//        personMap.put("Klintin", "Bob");
//        personMap.put("Ilon", "Bob");
//        personMap.put("Hanoven", "Trevis");
//        personMap.put("Parker", "Piter");
//        personMap.put("Alden", "Oland");
//
//
//        System.out.println(personMap);
//        System.out.println(sameName(personMap) ? "There are at less two persons with same name " : "There havent same names");
//        removePerson(personMap,"Stas");
//        System.out.println(personMap);


        List<Student> students = new ArrayList<>();
        students.add(new Student("Nick", 2));
        students.add(new Student("Alice", 5));
        students.add(new Student("Frek", 2));
        students.add(new Student("Devid", 3));
        students.add(new Student("Bark", 4));

//       Student.sortListByName(students);
//        System.out.println();
//       Student.sortListByCourse(students);
        Student.printStudents(students, 2);


    }

    //operations of union sets
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<Integer>(set1);
        union.addAll(set2);
        return union;
    }

    //intersection of two sets
    public static Set<Integer> intersect(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersaction = new HashSet<Integer>(set1);
        intersaction.retainAll(set2);
        return intersaction;

    }

    //    There are at less two persons with the same firstName?
    public static boolean sameName(Map<String, String> map) {
        Set<String> set1 = new HashSet<String>(map.values());
        return map.size() != set1.size();

    }

    //Remove from the map person whose firstName is [valu]
    public static void removePerson(Map<String, String> map, String valu) {
        map.values().removeIf(value -> value.contains(valu));
    }


}


