package AdventOfCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdventOfCode5 {

    public static void main(String[] args) {
        List<String> details = ReadInput.readAOC5();
        System.out.println(getresult1(details));
    }

    public static String getresult1(List<String> details) {
        StringBuilder total = new StringBuilder();
        int i = 0;

        while (i < details.size()) {
            String data = details.get(i);
            if (Character.isDigit(data.charAt(1))) {
                break;
            } else {
                i++;
                continue;
            }
        }

        List<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
        for (int z = 1; z < details.get(i).length(); z++) {
            if (Character.isDigit(details.get(i).charAt(z))) {

                Stack<Character> stack = new Stack<Character>();
                stacks.add(stack);
            }
        }
       // System.out.println(stacks.size());
        int j = i - 1;
        while (j >=0) {
            String data = details.get(j);
            for (int k = 0; k < data.length(); k++) {
                if(Character.isAlphabetic(data.charAt(k))  )
                {
                   Stack<Character> stack=stacks.get(k/4);
                   stack.push(data.charAt(k));
                   stacks.set(k/4,stack);
                } }
            j--;
        }

        i=i+2;
        for(;i<details.size();i++)
        {
            int firstindex=details.get(i).indexOf('e');
            int secondindex=details.get(i).indexOf('f');
            int count=Integer.parseInt(details.get(i).substring(firstindex+2,secondindex-1));
            int stack1=0;
            int stack2=0;

            for(int y=secondindex+4;y<details.get(i).length();y++)
            {
                if(Character.isDigit(details.get(i).charAt(y)))
                {
                    int x=Character.getNumericValue(details.get(i).charAt(y));
                    stack1=stack2;
                    stack2=x;
                }
            }
            Stack<Character> firstStack=stacks.get(stack1-1);
            Stack<Character> secondStack=stacks.get(stack2-1);
            System.out.println(count+" - "+stack1+" - "+stack2);
            Stack<Character> dummy=new Stack<>();
            for(int x=1;x<=count;x++)
            {
                char c;
                if(!firstStack.isEmpty())
                {
                    c=firstStack.pop();
                    dummy.push(c);
                }
            }
            while(!dummy.isEmpty())
            {
                secondStack.push(dummy.pop());
            }
            stacks.set(stack1-1,firstStack);
            stacks.set(stack2-1,secondStack);

        }
        for(int x=0;x< stacks.size();x++)
        {
            if(!stacks.get(x).isEmpty())
            total.append(stacks.get(x).peek());
        }
        return total.toString();
    }
}
