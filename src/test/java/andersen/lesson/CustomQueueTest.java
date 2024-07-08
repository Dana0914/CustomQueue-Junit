package andersen.lesson;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CustomQueueTest {

    @Test
    public void poll() {
        Queue queue = new Queue(5);
        queue.offer(1);
        queue.offer(2);

        Assertions.assertEquals(1, queue.poll());
        Assertions.assertEquals(2, queue.poll());
    }

    @Test
    public void remove() {
        Queue queue = new Queue(5);
        queue.offer(1);
        queue.offer(2);

        Assertions.assertTrue(queue.remove(1));
        Assertions.assertTrue(queue.remove(2));
    }
    @Test
    public void peek() {
        Queue queue = new Queue(5);
        queue.offer(1);
        queue.offer(2);

        Assertions.assertEquals(1, queue.peek());
        Assertions.assertNotEquals(2, queue.peek());
    }
    @Test
    public void contains() {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);

        Assertions.assertTrue(q.contains(1));
        Assertions.assertTrue(q.contains(2));
        Assertions.assertFalse(q.contains(3));
    }
    @Test
    public void add() {
        Queue queue = new Queue(5);

        Assertions.assertTrue(queue.add(1));
        Assertions.assertTrue(queue.add(2));
    }
    @Test
    public void offer() {
        Queue queue = new Queue(5);
        Assertions.assertTrue(queue.offer(1));
        Assertions.assertTrue(queue.offer(2));

    }
    @Test
    public void remove2() {
        Queue queue = new Queue(5);
        queue.offer(1);
        queue.offer(2);

        Assertions.assertTrue(queue.remove(1));
        Assertions.assertTrue(queue.remove(2));

    }
    @Test
    public void element() {
        Queue queue = new Queue(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Assertions.assertEquals(1, queue.element());
        Assertions.assertNotEquals(2, queue.element());
        Assertions.assertNotEquals(3, queue.element());

    }

}

