
//Write class Student that provides information about the name of the student and his course. Class Student should consist of
//        properties for access to these fields
//        constructor with parameters
//        method printStudents (List students, Integer course), which receives a list of students and the course number and prints to the console the names of the students from the list, which are taught in this course (use an iterator)
//        methods to compare students by name and by course
//        In the main() method
//        declare List students and add to the list five different students
//        display the list of students ordered by name
//        display the list of students ordered by course.

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class Student {
    private String name;
    private Integer course;

    public Student(String name, Integer course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public static void printStudents(List<Student> students, Integer course) {
        students.iterator().forEachRemaining(student -> {
            if (student.getCourse().equals(course)) {
                System.out.println("Student: " + student.getName());
            }
        });

    }

    public static List<Student> sortListByName(List<Student> list) {
        list.sort(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));
        displayList(list);
        return list;

    }

    public static List<Student> sortListByCourse(List<Student> list) {
        list.sort(Comparator.comparing(Student::getCourse));
        displayList(list);
        return list;

    }

    private static void displayList(List<Student> list) {
        for (Student student : list
        ) {
            System.out.println("Student: " + student.getName() + " course: " + student.getCourse());
        }
    }


}

