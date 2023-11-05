package testingbst;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bst.BinarySearchTree;

public class testbst {
    private BinarySearchTree<Integer> myIntTree;
    private BinarySearchTree<Integer> myIntTreeCustom;
    private BinarySearchTree<String> myStringTree;
    private BinarySearchTree<String> myStringTreeCustom;

    @BeforeEach
    void setUp() {
        myIntTree = new BinarySearchTree<>();
        myIntTreeCustom = new BinarySearchTree<>((i1,i2) -> i2-i1);
        myStringTree = new BinarySearchTree<>();
        myStringTreeCustom = new BinarySearchTree<>((w1,w2) -> w1.compareTo(w2));
    }

    @AfterEach
    void tearDown() {
        myIntTree = null;
        myIntTreeCustom = null;
        myStringTree = null;
        myStringTreeCustom = null;
    }

    @Test
    void testAddInt() {
        assertEquals(0, myIntTree.size());
        myIntTree.add(5);
        myIntTree.add(10);
        myIntTree.add(1);
        assertEquals(3, myIntTree.size(), "Incorrect size");
        myIntTree.printTree();
        myIntTree.clear();
        assertEquals(0, myIntTree.size(), "Incorrect size after clear");
    }

    @Test
    void testAddString() {
        assertEquals(0, myStringTree.size());
        myStringTree.add("B");
        myStringTree.add("C");
        myStringTree.add("A");
        assertEquals(3, myStringTree.size());
        myStringTree.printTree();
    }

    @Test 
    void testEmpty() {
        assertEquals(0, myIntTree.size(), "Incorrect size of empty tree");
    }

    @Test
    void testClear() {
        myIntTree.add(5);
        myIntTree.add(10);
        myIntTree.add(1);
        myIntTree.add(12);
        assertEquals(4, myIntTree.size());
        myIntTree.clear();
        assertEquals(0, myIntTree.size(), "Incorrect size after clear");
    }

    @Test
    void testHeight() {
        myIntTree.add(5);
        myIntTree.add(10);
        myIntTree.add(1);
        myIntTree.add(12);
        assertEquals(4, myIntTree.size());
        assertEquals(3, myIntTree.height());
    }

    @Test
    void testAddTwoSame() {
        myIntTree.add(5);
        assertFalse(myIntTree.add(5));
        assertEquals(1, myIntTree.size());
    }

    @Test
    void testAddIntCustom() {
        assertEquals(0, myIntTree.size());
        myIntTreeCustom.add(5);
        myIntTreeCustom.add(10);
        myIntTreeCustom.add(1);
        assertEquals(3, myIntTreeCustom.size(), "Incorrect size");
        myIntTreeCustom.printTree();
        myIntTreeCustom.clear();
        assertEquals(0, myIntTreeCustom.size(), "Incorrect size after clear");
    }
}
