package testqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;


public class TestAppendFifoQueue {
    private FifoQueue<Integer> myIntQueue1;
    private FifoQueue<Integer> myIntQueue2;

    @BeforeEach
    void setUp() {
        myIntQueue1 = new FifoQueue<Integer>();
        myIntQueue2 = new FifoQueue<Integer>();
    }

    @AfterEach
    void tearDown() {
        myIntQueue1 = null;
        myIntQueue2 = null;
    }

    @Test
    void testAppendTwoEmptyQueue() {
        myIntQueue1.append(myIntQueue2);
        assertTrue(myIntQueue1.isEmpty(), "Wrong result from empty of queue");
        assertEquals(0, myIntQueue1.size(), "Wrong size of Empty queue");
    }

    @Test
    void testAppendEmptyToNonEmpty() {
        myIntQueue1.offer(1);
        myIntQueue1.offer(2);
        myIntQueue1.offer(3);
        myIntQueue1.append(myIntQueue2);
        assertEquals(3, myIntQueue1.size(), "Wrong size of queue");
        for (int i = 1; i <= 3; i++) {
			int k = myIntQueue1.poll();
			assertEquals(i, k, "poll returns incorrect element");
		}
		assertEquals(0, myIntQueue1.size(), "Wrong size after poll");
		assertTrue(myIntQueue1.isEmpty(), "Queue not empty after poll");
    }

    @Test
    void testAppendNonEmptyToEmpty() {
        myIntQueue1.offer(1);
        myIntQueue1.offer(2);
        myIntQueue1.offer(3);
        myIntQueue2.append(myIntQueue1);
        assertEquals(3, myIntQueue1.size(), "Wrong size of queue");
        for (int i = 1; i <= 3; i++) {
			int k = myIntQueue1.poll();
			assertEquals(i, k, "poll returns incorrect element");
		}
		assertEquals(0, myIntQueue1.size(), "Wrong size after poll");
		assertTrue(myIntQueue1.isEmpty(), "Queue not empty after poll");
    }

    @Test
    void testAppendNonEmpty_Poll() {
        myIntQueue1.offer(1);
        myIntQueue1.offer(2);
        myIntQueue1.offer(3);
        myIntQueue2.offer(4);
        myIntQueue2.offer(5);
        myIntQueue2.offer(6);
        myIntQueue1.append(myIntQueue2);
        assertEquals(6, myIntQueue1.size(), "Wrong size of queue");
        for (int i = 1; i <= 6; i++) {
			int k = myIntQueue1.poll();
			assertEquals(i, k, "poll returns incorrect element");
		}
		assertEquals(0, myIntQueue1.size(), "Wrong size after poll");
		assertTrue(myIntQueue1.isEmpty(), "Queue not empty after poll");
    }

    @Test
    void testAppendSame() {
        assertThrows(IllegalArgumentException.class, () -> myIntQueue1.append(myIntQueue1));
    }
}
