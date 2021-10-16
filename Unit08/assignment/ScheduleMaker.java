package assignment;

import java.util.LinkedList;
import java.util.List;

public class ScheduleMaker {
    /**
     * Creates a schedule (list) of most possible courses that dont overlap
     * 
     * This is a greedy algorithm and will not always produce the list with the most courses.
     * for example: where the shorted course overlaps with 2 other courses that are longer.
     *     suppose a list of classes containing Physics (8-12), English (11-14), Math(13-17).
     *     This greedy algorithm would select English and stop there since Physics and Math overlap with it.
     * 
     * @param courses List of course options
     * @return supposed list with most possible courses
     */
    public static List<Course> makeSchedule(List<Course> courses) {
        // Make empty schedule list that will be returned at the end
        // 
        // loop for size of courses
        //     for course in courses
        //         find course with lowest duration
        //     check if course overlaps with already selected courses
        //     if not add to schedule lists
        //     remove already added course from courses list
        // return schedule list

        List<Course> coursesCopy = new LinkedList<>(List.copyOf(courses));
        List<Course> schedule = new LinkedList<>();

        for (int i = 0; i < courses.size(); i ++) {
            Course greedyCourse = coursesCopy.get(0);
            for (Course checkCourse : coursesCopy) {
                if (checkCourse.duration() < greedyCourse.duration()) {
                    greedyCourse = checkCourse;
                }
            }

            if (!hasOverlap(greedyCourse, schedule)) {
                schedule.add(greedyCourse);
            }
            coursesCopy.remove(greedyCourse);
        }
        return schedule;
    }

    private static boolean hasOverlap(Course c1, List<Course> courses) {
        if (courses.contains(c1)) return true;
        for (Course c2 : courses) {
            boolean overlaps = c1.getStart() > c2.getStart() && c1.getStart() < c2.getEnd() ||
            c1.getEnd() > c2.getStart() && c1.getEnd() < c2.getEnd() ||
            c1.getStart() < c2.getStart() && c1.getEnd() >= c2.getEnd() ||
            c1.getStart() == c2.getStart() && c1.getEnd() != c2.getEnd();

            if (overlaps) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Course> schedule = makeSchedule(Course.exampleCourses());
        System.out.println(schedule);
    }
}