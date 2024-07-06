package andersen.lesson;

import java.util.*;

public class Queue implements IQueue {
    Object[] queue;
    int front;
    int rear;
    int size;

    public Queue() {
        queue = new Object[size];
        front = 0;
        rear = 0;
        size = 0;
    }
    @Override
    public boolean add(Object o) {
        if (size == queue.length) {
            throw new RuntimeException("Queue is full");
        }
        if (o == null) {
            throw new NullPointerException("Null is not allowed");
        }
        for (int i = front; i <= rear; i++) {
            if (queue[i] == o) {
                throw new IllegalArgumentException("Element already exists");
            }
        }
        queue[rear] = o;
        rear++;
        size++;
        return true;
    }

    @Override
    public boolean offer(Object o) {
        if (size <= queue.length) {
            resize();
        }
        if (o == null) {
            return false;
        }
        queue[rear] = o;
        rear++;
        size++;
        return true;
    }

    @Override
    public Object remove() {
        if (size == 0) {
            throw new IllegalArgumentException("Queue is empty");
        }
        if (front == rear) {
            throw new IllegalArgumentException("Queue is empty");
        }
        for (int i = front; i <= rear ; i++) {
            if (queue[i] != null) {
                queue[i] = queue[i + 1];
            }
        }
        size--;
        return true;

    }

    @Override
    public Object poll() {
        if (size == 0) {
            System.out.println("Queue is empty");
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
        size--;
        return o;
    }

    @Override
    public Object element() {
        if (size == 0) {
            throw new NoSuchElementException("Empty queue");
        }
        if (front == rear) {
            throw new NoSuchElementException("Empty queue");
        }
        if (queue[front] == null) {
            return null;
        }
        return queue[front];
    }

    @Override
    public Object peek() {
        if (size == 0) {
            return null;
        }
        if (front == rear) {
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
            if (Objects.equals(queue[i], o)) {
                queue[i] = null;
                return true;
            }
            size--;
        }
        return false;
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
        if (size == 0) {
            System.out.println("Empty queue");
        }
        for (int i = front; i <= rear; i++) {
            if (queue[i] != null) {
                queue[i] = null;
                size--;
            }
        }

    }

    public void resize() {
        queue = Arrays.copyOf(queue, (size + 1) * 2);

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
}
