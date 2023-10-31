package testqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

public class TestAppendFifoQueue {
    private Queue<Integer> myIntQueue1;
    private Queue<Integer> myIntQueue2;
    private Queue<String> myStringQueue1;
    private Queue<String> myStringQueue2;

    @BeforeEach
    void setUp() {
        myIntQueue1 = new FifoQueue<Integer>();
        myIntQueue2 = new FifoQueue<Integer>();
        myStringQueue1 = new FifoQueue<String>();
        myStringQueue2 = new FifoQueue<String>();
    }

    @AfterEach
    void tearDown() {
        myIntQueue1 = null;
        myIntQueue2 = null;
        myStringQueue1 = null;
        myStringQueue2 = null;
    }

    @Test
    void testTwoEmptyQueue() {
        
    }

}
