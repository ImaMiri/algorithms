package datastructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fmiri on 18/07/2016.
 *
 * @author Ima Miri <fmiri@ebay.com>
 */
public class TrieTest {
    private Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();
        trie.add("at");
        trie.add("Hello");
        trie.add("Been");
        trie.add("yes");
        trie.add("water");
        trie.add("be");
    }

    @Test
    public void testInsert() {

        assertTrue(trie.find("water"));
        assertTrue(trie.find("at"));
        assertFalse(trie.find("Beat"));
        assertFalse(trie.find("Test"));

        trie.remove("water");
        System.out.println(trie.find("water"));
    }

    @Test
    public void testDelete() {

        assertTrue(trie.find("Hello"));
        assertTrue(trie.find("at"));
        trie.remove("Hello");
        trie.remove("at");
        assertFalse(trie.find("Hello"));
        assertFalse(trie.find("at"));
    }
}
