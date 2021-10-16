package set;

import java.util.Iterator;
import java.util.List;

public class ListSetIterator<T> implements Iterator<T> {
    private List<T> list;
    private int index;

    public ListSetIterator(List<T> list) {
        this.list = list;
    }
    
    @Override
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        T element = list.get(index);
        index++;
        return element;
    }
}
