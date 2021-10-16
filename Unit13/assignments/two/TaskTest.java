package assignments.two;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class TaskTest {
    @Test
    public void testGreedyAlgorithm() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(2, "Mop"));
        tasks.add(new Task(1, "Sweep"));
        tasks.add(new Task(6, "Clean Office"));
        tasks.add(new Task(3, "Laundry"));
        tasks.add(new Task(4, "Landscaping"));
        tasks.add(new Task(5, "Clean Basement"));
        List<Task> actual = Task.greedyTaskList(tasks, 6);
        
        List<Task> expected = new ArrayList<>();
        expected.add(tasks.get(1));
        expected.add(tasks.get(0));
        expected.add(tasks.get(3));

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testGreedyAlgorithmNoTime() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(7, "Mop"));
        tasks.add(new Task(7, "Sweep"));
        tasks.add(new Task(7, "Clean Office"));
        tasks.add(new Task(7, "Laundry"));
        tasks.add(new Task(7, "Landscaping"));
        tasks.add(new Task(7, "Clean Basement"));
        List<Task> actual = Task.greedyTaskList(tasks, 6);
        
        List<Task> expected = new ArrayList<>();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
