

import java.util.HashMap;


class Trie {

    TrieNode root;
    public Trie() {

        root=new TrieNode();
        root.setLetter('/');
        root.setEndLetter(false);
    }


    public void insert(String word) {

        TrieNode node=root;

        for(int i=0;i<word.length();i++)
        {
            char w=word.charAt(i);
            if(!node.nextLetters.containsKey(w))
            {
                TrieNode newNode=new TrieNode();
                newNode.setLetter(w);
                node.nextLetters.put(w,newNode);
            }
            node=node.nextLetters.get(w);

        }
        node.setEndLetter(true);

    }

    public boolean search(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char w=word.charAt(i);
            if(!node.nextLetters.containsKey(w))
            {
                return false;
            }
            node=node.nextLetters.get(w);
        }
        return node.isEndLetter();

    }

    public boolean startsWith(String prefix) {

        TrieNode node=root;
        boolean endWith=false;
        for(int i=0;i<prefix.length();i++)
        {
            char w=prefix.charAt(i);
            if(!node.nextLetters.containsKey(w))
            {
                return false;
            }
            node=node.nextLetters.get(w);
        }
        return true;

    }
}
