package set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Time complexity could be improved by storing/using hashCodes like HashSet does to check if a an element is already in the list
 */
public class ListSet<T> implements Set<T> {
    List<T> list = new ArrayList<>();

    /**
     * Time complexity O(n)
     */
    @Override
    public void add(T t) {
        if (!list.contains(t)) {
            list.add(t);
        }
    }

    /**
     * Time complexity O(n)
     */
    @Override
    public void remove(T t) {
        list.remove(t);
    }

    /**
     * Time complexity O(n)
     */
    @Override
    public boolean contains(T t) {
        return list.contains(t);
    }

    /**
     * Time complexity O(1)
     */
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListSetIterator<>(list);
    }
}
