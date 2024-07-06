package andersen.lesson;

public interface IQueue {

    boolean add(Object o);
    boolean offer(Object o);
    Object remove();
    Object poll();
    Object element();
    Object peek();
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    boolean remove(Object o);
    void clear();
}
