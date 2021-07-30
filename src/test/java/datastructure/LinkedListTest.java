package datastructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by fmiri on 21/06/2016.
 *
 * @author Ima Miri <ima.miri11@gmail.com>
 */
public class LinkedListTest {

    private static final int LONG_LIST_LENGTH = 10;

    LinkedList<Integer> emptyList;
    LinkedList<String> shortList;
    LinkedList<Integer> mediumList;
    LinkedList<Integer> longerList;

    @Before
    public void setUp() {
        shortList = new LinkedList<String>();
        shortList.add("A");
        shortList.add("B");
        emptyList = new LinkedList<Integer>();
        longerList = new LinkedList<Integer>();
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            longerList.add(i);
        }
        mediumList = new LinkedList<Integer>();
        mediumList.add(65);
        mediumList.add(21);
        mediumList.add(42);
    }

    @Test
    public void testGet() {
        try {
            emptyList.get(0);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }

        assertEquals("Check first", "A", shortList.get(0));
        assertEquals("Check second", "B", shortList.get(1));

        try {
            shortList.get(-1);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            shortList.get(2);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }

        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
        }

        try {
            longerList.get(-1);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            longerList.get(LONG_LIST_LENGTH);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
    }

    @Test
    public void testRemove() {
        try {
            emptyList.remove(0);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }

        LinkedList<String> list = new LinkedList<String>();
        list.add("AA");
        String str = list.remove(0);
        assertEquals("Removed : check head is removed", "AA", str);

        list.add("AA");
        list.add("BB");
        str = list.remove(1);
        assertEquals("Removed : check tail is removed", "BB", str);

        list.add("CC");
        list.add("DD");
        list.add("EE");
        str = list.remove(1);
        assertEquals("Removed : check element is removed", "CC", str);
        str = list.remove(1);
        assertEquals("Removed : check element is removed", "DD", str);
    }

    @Test
    public void testAddEnd() {
        shortList.add("C");
        shortList.add("D");
        assertEquals("Add: check element C is added ", "C", shortList.get(2));
        assertEquals("Add: check element D is added ", "D", shortList.get(3));
        assertEquals("Size: check size is correct ", 4, shortList.size());
        String a = shortList.remove(2);
        assertEquals("Remove: check a is correct ", "C", a);
    }

    @Test
    public void testSize() {
        assertEquals("Size: check size is correct for shortList ", 2, shortList.size());
        assertEquals("Size: check size is correct for longerList ", 10, longerList.size());
        assertEquals("Size: check size is correct for List1 ", 3, mediumList.size());
    }

    @Test
    public void testAddAtIndex() {
        LinkedList<String> list = new LinkedList<String>();
        list.add(0, "AA");
        list.add(1, "BB");
        assertEquals("Add: check size is correct ", 2, list.size());
        assertEquals("Add: check the head is correct ", "AA", list.get(0));
        assertEquals("Add: check the tail is correct ", "BB", list.get(1));

        list.add(2, "EE");
        list.add(2, "CC");
        list.add(3, "DD");
        assertEquals("Add: check size is correct ", 5, list.size());
        assertEquals("Add: check the head is correct ", "CC", list.get(2));
        assertEquals("Add: check the tail is correct ", "DD", list.get(3));
        assertEquals("Add: check the tail is correct ", "EE", list.get(4));
    }

    @Test
    public void testSet() {
        assertEquals("Set: check head is correct", "A", shortList.get(0));
        shortList.set(0, "AA");
        assertEquals("Set: check head is correct", "AA", shortList.get(0));

        assertEquals("Set: check tail is correct", "B", shortList.get(1));
        shortList.set(1, "CC");
        assertEquals("Set: check tail is correct", "CC", shortList.get(1));

        shortList.add("CC");
        shortList.add("EE");
        shortList.add("EE");

        assertEquals("Set: check element is correct", "CC", shortList.get(1));
        shortList.set(1, "BB");
        shortList.set(3, "DD");
        assertEquals("Set: check element is correct", "BB", shortList.get(1));
        assertEquals("Set: check element is correct", "DD", shortList.get(3));
    }
}
