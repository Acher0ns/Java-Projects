package assignment6_1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class HeapPQTest {
    @Test
    public void testConstructor() {
        HeapPQ pq = new HeapPQ();

        assertEquals(pq.size(), 0);
    }

    @Test
    public void testEnqueue() {
        HeapPQ pq = new HeapPQ();

        pq.enqueue(9);
        pq.enqueue(1);
        pq.enqueue(2);
        pq.enqueue(10);

        assertEquals(pq.size(), 4);
    }

    @Test
    public void testDequeue() {
        HeapPQ pq = new HeapPQ();

        pq.enqueue(9);
        pq.enqueue(1);
        pq.enqueue(2);
        pq.enqueue(10);

        assertEquals(pq.dequeue(), 1);
    }

    @Test
    public void testBoth() {
        HeapPQ pq = new HeapPQ();

        pq.enqueue(9);
        pq.enqueue(1);
        pq.enqueue(2);
        pq.enqueue(10);

        assertEquals(pq.dequeue(), 1);
        pq.enqueue(3);
        assertEquals(pq.dequeue(), 2);

        assertEquals(pq.dequeue(), 3);
        pq.enqueue(20);
        assertEquals(pq.dequeue(), 9);
    }
}
