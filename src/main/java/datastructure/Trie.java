package datastructure;

import java.util.Map;
import java.util.Set;

/**
 * Created by fmiri on 18/07/2016.
 *
 * @author Ima Miri <fmiri@ebay.com>
 */
public class Trie {

    private TrieNode root;
    private int size;

    public Trie() {
        root = new TrieNode();
        size = 0;
    }

    public boolean add(String word) {
        TrieNode trie = root;
        if (trie == null || word == null)
            return false;

        char[] chars = word.toCharArray();
        int counter = 0;
        while (counter < chars.length) {
            Set<Character> childs = trie.getChildren().keySet();
            if (!childs.contains(chars[counter])) {
                insertChar(trie, chars[counter]);
                if (counter == chars.length - 1) {
                    getChild(trie, chars[counter]).setIsWord(true);
                    size++;
                    return true;
                }
            }
            trie = getChild(trie, chars[counter]);
            if (trie.getText().equals(word) && !trie.isWord()) {
                trie.setIsWord(true);
                size++;
                return true;
            }
            counter++;
        }
        return false;
    }

    public boolean find(String str) {
        Map<Character, TrieNode> children = root.getChildren();
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.getChildren();
            } else return false;
        }

        return true;
    }

    public boolean remove(String str) {

        return findNode(root, str);
    }

    private TrieNode getChild(TrieNode trie, Character c) {
        return trie.getChildren().get(c);
    }

    private TrieNode insertChar(TrieNode trie, Character c) {
        if (trie.getChildren().containsKey(c)) {
            return null;
        }

        TrieNode next = new TrieNode(trie.getText() + c.toString());
        trie.getChildren().put(c, next);
        return next;
    }

    private boolean findNode(TrieNode trie, String s) {

        Map<Character, TrieNode> children = root.getChildren();

        TrieNode parent = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (children.containsKey(c)) {
                parent = trie;
                trie = children.get(c);
                children = trie.getChildren();
                if (trie.getText().equals(s)) {

                    parent.getChildren().remove(c);
                    trie = null;
                    return true;
                }
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }
}
