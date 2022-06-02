

import java.util.HashMap;


public class Trie {


    public static void main(String[] args)
    {
        Trie obj=new Trie();
        obj.insert("sravya");
        System.out.println(obj.search("sraya"));
        System.out.println(obj.startsWith("sra"));
    }

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
                boolean isEnd= i==word.length()-1?true:false;
                newNode.setEndLetter(isEnd);
                node.nextLetters.put(w,newNode);
            }
            node=node.nextLetters.get(w);
        }

    }

    public boolean search(String word) {

        TrieNode node=root;
        boolean endWith=false;
        for(int i=0;i<word.length();i++)
        {
            char w=word.charAt(i);
            if(!node.nextLetters.containsKey(w))
            {
                return false;
            }
            node=node.nextLetters.get(w);
            endWith=node.isEndLetter();
        }
        return endWith;
    }
    public boolean startsWith(String word) {

        TrieNode node=root;
        boolean endWith=false;
        for(int i=0;i<word.length();i++)
        {
            char w=word.charAt(i);
            if(!node.nextLetters.containsKey(w))
            {
                return false;
            }
            node=node.nextLetters.get(w);
        }
        return true;
    }
}


