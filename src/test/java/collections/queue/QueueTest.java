package collections.queue;

import collections.exception.OverflowException;
import collections.exception.UnderflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class QueueTest {

    //Mocks
    private Queue queue;

    @BeforeEach
    void setUp(){
        queue = new Queue();
    }

    @Test
    void checkQueueIsEmpty(){
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    void willThroExceptionOnUnderflow(){
        Assertions.assertTrue(queue.isEmpty());

        Assertions.assertThrows(UnderflowException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    void quequeIsEmptyAfterEnqueueAndDequeue(){
        queue.enqueue(1);
        queue.dequeue();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    void enqueueInFullQueueThrowsOverFlowException(){
        for(int i = 0; i < 10; i++){
            queue.enqueue(i);
        }
        Assertions.assertThrowsExactly(OverflowException.class, () -> queue.enqueue(5));
    }

    @Test
    void enqueueWillNotEmpty(){
        queue.enqueue(0);
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    void fifoWillWorksok(){
        queue.enqueue(0);
        queue.enqueue(1);
        Assertions.assertEquals(0, queue.dequeue());
        Assertions.assertEquals(1, queue.dequeue());
    }

}
