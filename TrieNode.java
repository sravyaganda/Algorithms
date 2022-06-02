

import java.util.HashMap;

public class TrieNode {

    char letter;
    HashMap<Character,TrieNode> nextLetters;
    boolean endLetter;

    public TrieNode()
    {
        nextLetters=new HashMap<Character,TrieNode>();
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public HashMap<Character, TrieNode> getNextLetters() {
        return nextLetters;
    }

    public void setNextLetters(HashMap<Character, TrieNode> nextLetters) {
        this.nextLetters = nextLetters;
    }

    public boolean isEndLetter() {
        return endLetter;
    }

    public void setEndLetter(boolean endLetter) {
        this.endLetter = endLetter;
    }


}
