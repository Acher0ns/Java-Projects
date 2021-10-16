package assignments.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {
    private int hours;
    private String name;

    public Task(int hours, String name) {
        this.hours = hours;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "<" + hours + ">";
    }

    public int getHours() {
        return hours;
    }

    public String getName() {
        return name;
    }

    /**
     * Greedy algorithm to get most amount of tasks that can be done in a given amount of time
     * @param tasks available
     * @param timeAllotted to complete the tasks
     * @return list of tasks that can be done in the allotted time
     */
    public static List<Task> greedyTaskList(List<Task> tasks, int timeAllotted) {
        // Make a list of only tasks that can be completed in the allotted time
        List<Task> validtasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getHours() <= timeAllotted) {
                validtasks.add(task);
            }
        }
        
        List<Task> tasksAbleToComplete = new ArrayList<>();

        // While time is left and there are valid tasks left
        while (timeAllotted > 0 && validtasks.size() > 0) {
            Task minTask = new Task(Integer.MAX_VALUE, "");
            // gets task that takes the least amount of time to complete
            for (int i = 0; i < validtasks.size(); i++) {
                Task task = validtasks.get(i);
                if (task.getHours() < minTask.getHours()) {
                    minTask = task;
                }
            }

            // Makes sure minTask can be fit within time allotted
            if (minTask.getHours() <= timeAllotted) {
                tasksAbleToComplete.add(minTask);
                validtasks.remove(minTask);
                timeAllotted -= minTask.getHours();
            }
            // Reset midTask variable which is a place holder
            minTask = new Task(Integer.MAX_VALUE, "");
        }
        return tasksAbleToComplete;
    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(2, "Mop"));
        tasks.add(new Task(1, "Sweep"));
        tasks.add(new Task(6, "Clean Office"));
        tasks.add(new Task(3, "Laundry"));
        tasks.add(new Task(4, "Landscaping"));
        tasks.add(new Task(5, "Clean Basement"));
        List<Task> result = greedyTaskList(tasks, 6);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
