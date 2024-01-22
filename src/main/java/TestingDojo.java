import collections.queue.Queue;

public class TestingDojo {
    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println(String.format("Is the queue empty: %s", queue.isEmpty()));
        
        queue.enqueue(10);
        System.out.println(String.format("Is the queue empty: %s", queue.isEmpty()));

        queue.enqueue(20);
        System.out.println(String.format("Is the queue empty: %s", queue.isEmpty()));

        queue.dequeue();
        System.out.println(String.format("Is the queue empty: %s", queue.isEmpty()));

        queue.dequeue();
        System.out.println(String.format("Is the queue empty: %s", queue.isEmpty()));
    }
}