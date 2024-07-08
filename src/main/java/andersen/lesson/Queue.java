package andersen.lesson;

import java.util.*;

public class Queue implements IQueue {
    Object[] queue;
    int front;
    int rear;
    int size;

    public Queue(int capacity) {
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;

    }
    @Override
    public boolean add(Object o) {
        if (isFull()) {
            throw new IllegalArgumentException("Queue is full");
        }
        if (o == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        for (int i = front; i <= rear; i++) {
            if (queue[i] == o) {
                throw new IllegalArgumentException("Element already exists");
            }
        }
        queue[++rear] = o;
        size++;
        return true;
    }

    @Override
    public boolean offer(Object o) {
        if (size == queue.length) {
            //resizing the size of queue
            resize(((queue.length * 3) / 2) + 1);
        }
        if (o == null) {
            return false;
        }
        queue[++rear] = o;
        size++;
        return true;
    }

    @Override
    public Object remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        for (int i = front; i <= rear ; i++) {
            if (queue[i] != null) {
                queue[i] = queue[i + 1];
            }
        }
        rear--;
        size--;

        //shrinking the size of queue
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return true;

    }

    @Override
    public Object poll() {
        if (isEmpty()) {
            return false;
        }
        Object o = queue[front];
        if (o == null) {
            return false;
        }
        for (int i = front; i <= rear ; i++) {
            if (queue[i] != null) {
                queue[i] = queue[i + 1];
            }
        }
        rear--;
        size--;
        //shrinking the size of queue
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return o;
    }

    @Override
    public Object element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty queue");
        }
        if (queue[front] == null) {
            return null;
        }
        return queue[front];
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        if (queue[front] == null) {
            return null;
        }
        return queue[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == queue.length;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = front; i <= rear; i++) {
            if (Objects.equals(queue[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = front; i <= rear; i++) {
            if (queue[i] == o) {
                queue[i] = null;
            }
        }
        size--;
        rear--;
        //shrinking the size of queue
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return true;
    }

    public void display() {
        for (int i = front; i <= rear; i++) {
            if (queue[i] != null) {
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println();
    }
    @Override
    public void clear() {
        if (isEmpty()) {
            System.out.println("Empty queue");
        }
        for (int i = front; i <= rear; i++) {
            if (queue[i] != null) {
                queue[i] = null;
                size--;
            }
        }

    }

    public void resize(int newCapacity) {
        Object[] newQueue = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[i];
        }
        queue = newQueue;
        front = 0;
        rear = size-1;


    }

    @Override
    public String toString() {
        return "Queue{" +
                "queue=" + Arrays.toString(queue) +
                ", front=" + queue[front] +
                ", rear=" + queue[rear] +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue queue1 = (Queue) o;
        return front == queue1.front && rear == queue1.rear && size == queue1.size && Objects.deepEquals(queue, queue1.queue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(queue), front, rear, size);
    }
}
