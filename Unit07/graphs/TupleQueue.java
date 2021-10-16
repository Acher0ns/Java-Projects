package graphs;

import java.util.LinkedList;
import java.util.List;

import ds.Queue;

public class TupleQueue<T> implements Queue<PathTuple<T>> {
    private List<PathTuple<T>> queue = new LinkedList<>();

    @Override
    public void enqueue(PathTuple<T> tuple) {
        queue.add(tuple);
    }

    @Override
    public PathTuple<T> dequeue() {
       if (queue.size() == 0) {
           return null;
       }

       int indexOfShortest = 0;
       double shortestDistance = queue.get(0).getDistance();

       for (int i = 0; i < queue.size(); i++) {
           double dist = queue.get(i).getDistance();
           if (dist < shortestDistance) {
               indexOfShortest = i;
               shortestDistance = dist;
           }
       }
       return queue.remove(indexOfShortest);
    }

    @Override
    public int size() {
        return queue.size();
    }
}
