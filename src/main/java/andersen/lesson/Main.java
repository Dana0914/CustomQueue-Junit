package andersen.lesson;



public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add("ball");
        queue.add("ok");
        queue.add("err");
        queue.add("bell");
        queue.add("op");

        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);

    }
}
