package lambdas;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private double gpa;

    public Student(String firstName, String lastName, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + ": " + gpa;
    }

    @Override
    public int compareTo(Student o) {
        return this.getFirstName().compareTo(o.getFirstName());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public static void main(String[] args) {
        Student a = new Student("Kamron", "Cole", 3.8);
        Student b = new Student("Carter", "Crooker", 3.8);
        Student c = new Student("Alex", "Feldman", 3.5);
        Student d = new Student("Andrew", "Davis", 3.0);

        List<Student> students = new LinkedList<>();
        students.add(d);
        students.add(c);
        students.add(b);
        students.add(a);

        System.out.println(students);

        // Anon class
        students.sort(new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        System.out.println(students);

        // Lambda I
        students.sort((Student o1, Student o2) -> {
            return o2.getLastName().compareTo(o1.getLastName());
        });

        System.out.println(students);

        // Lambda II
        students.sort((o1, o2) -> o2.getLastName().compareTo(o1.getLastName()));

        System.out.println(students);

        // Lambda III (Method Reference, requires implementation in class)
        students.sort(Student::compareTo);

        System.out.println(students);

        // Streams (forEach can also be called on students directly)
        students.stream().forEach(e -> System.out.println(e.firstName + " " + e.lastName));
        students.stream().forEach(System.out::println);

        System.out.println();

        // Filters and Predicates (prints students with gpa at or above 3.6)
        students.stream().filter(e -> e.getGpa() >= 3.6).forEach(System.out::println);
    }
}
