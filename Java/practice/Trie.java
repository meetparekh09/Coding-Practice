package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;


class TrieNode {
    HashMap<Character, TrieNode> childrens;
    boolean isLeaf;

    public TrieNode() {
        childrens = new HashMap<>();
        isLeaf = false;
    }
}

public class Trie {

    public static void main(String []args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hear");
        trie.insert("he");

        System.out.println(trie.countMatching("he"));
        System.out.println(trie.countMatching("hell"));
        System.out.println(trie.countMatching("a"));
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
        //root.isLeaf = true;
    }

    public void insert(String word) {
        TrieNode traveller = root;

        for(int i = 0; i < word.length(); i++) {
            //traveller.isLeaf = false;
            Character c = new Character(word.charAt(i));
            if(!traveller.childrens.containsKey(c)) {
                traveller.childrens.put(c, new TrieNode());
            }
            traveller = traveller.childrens.get(c);
        }
        traveller.isLeaf = true;
    }

    public TrieNode find(String prefix) {
        TrieNode traveller = root;

        for(int i = 0; i < prefix.length(); i++) {
            Character c = new Character(prefix.charAt(i));
            if(!traveller.childrens.containsKey(c))
                return null;
            traveller = traveller.childrens.get(c);
        }

        return traveller;
    }

    public int countMatching(String prefix) {
        TrieNode node = find(prefix);
        if(node == null)
            return 0;

        LinkedList<TrieNode> queue = new LinkedList();
        queue.add(node);

        int count = 0;

        while(queue.size() > 0) {
            TrieNode n = queue.poll();
            if(n.isLeaf)
                count++;

            Iterator<Character> iterator = n.childrens.keySet().iterator();
            while(iterator.hasNext()) {
                queue.add(n.childrens.get(iterator.next()));
            }
        }

        return count;
    }
}
