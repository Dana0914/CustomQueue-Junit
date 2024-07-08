package andersen.lesson;



public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.offer("ball");
        queue.offer("ok");
        queue.offer("err");
        queue.offer("bell");
        queue.offer("op");
        queue.offer("rule");
        queue.offer("dull");

        System.out.println(queue);
        System.out.println(queue.remove("op"));
        System.out.println(queue);


    }
}
