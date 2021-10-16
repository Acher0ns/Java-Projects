package assignment;

import java.util.Arrays;
import java.util.List;

/**
 * A class representing a course that may be taken by students.
 * 
 * @author GCCIS Faculty
 */
public class Course {
    private final String name;
    private final int start;
    private final int end;

    /**
     * Creates a new course with the specified attributes.
     * 
     * @param name The name of the new course.
     * @param start The start time - an even hour using military time, e.g. 14 
     * is 2PM.
     * @param end The end time - an even hour using military time, e.g. 14 is
     * 2PM.
     */
    public Course(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    /**
     * Returns a list of pre-made courses suitable for testing.
     * 
     * @return A list of pre-made courses.
     */
    public static List<Course> exampleCourses() {
        return Arrays.asList(
            new Course("Art", 10, 14),
            new Course("Calculus", 9, 11),
            new Course("Physics", 10, 12),
            new Course("Programming", 8, 10),
            new Course("Design Patterns", 10, 11),
            new Course("Wines of the World", 12, 13),
            new Course("Intro to Engineering", 13, 15),
            new Course("Software Construction", 11, 13),
            new Course("Advanced OO Programming", 14, 16),
            new Course("Economics", 15, 17),
            new Course("Senior Project", 17, 18)
        );
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns the duration of the course in hours.
     * 
     * @return The duration of the course in hours.
     */
    public int duration() {
        return end - start;
    }

    /**
     * Returns a string representation of the course in the format 
     * "<name>(<start>-<end>)", e.g. "GCIS-124(8-10)".
     */
    @Override
    public String toString() {
        return name + "(" + start + "-" + end + ")";
    }
}
