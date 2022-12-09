package AdventOfCode;

import java.util.List;
import java.util.Stack;

public class AdventOfCode7 {

    public static void main(String[] args) {
        List<String> commands = ReadInput.readAOC7();
        //System.out.println(getresult1(commands));
        System.out.println(getresult2(commands));
    }

//    public static int getresult1(List<String> commands) {
//        int result = 0;
//        int totalSum = 0;
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < commands.size(); i++) {
//            String command = commands.get(i);
//
//            if (command.indexOf("cd") != -1 && !command.equals("$ cd ..")) {
//                stack.push(result);
//                result = 0;
//            } else if (command.equals("$ cd ..")) {
//                if (result <= 100000) {
//                    totalSum += result;
//                }
//                int currentResult = stack.pop();
//                result = currentResult + result;
//            } else if (Character.isDigit(command.charAt(0))) {
//                int size = Integer.parseInt(command.replaceAll("[^0-9]", ""));
//                result += size;
//            }
//            System.out.println(result + " - " + stack.size() + " - " + totalSum);
//        }
//        return totalSum;
//    }

    public static int getresult2(List<String> commands) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            if (command.indexOf("cd") != -1 && !command.equals("$ cd ..")) {
                stack.push(result);
                result = 0;
            } else if (command.equals("$ cd ..")) {
                int currentResult = stack.pop();
                result = currentResult + result;
            } else if (Character.isDigit(command.charAt(0))) {
                int size = Integer.parseInt(command.replaceAll("[^0-9]", ""));
                result += size;
            }
        }

        int spaceUsed=result;
        while(stack.size()>2)
        {
            int currentSpace=spaceUsed+stack.pop();
            int newSpace=currentSpace+stack.pop();
            stack.push(newSpace);
        }

        int freespace= (70000000-stack.pop());
        int result2=Integer.MAX_VALUE;
       System.out.println("FreeSpace"+"-"+freespace);
       result=0;
        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            if (command.indexOf("cd") != -1 && !command.equals("$ cd ..")) {
                stack.push(result);
                result = 0;
            } else if (command.equals("$ cd ..")) {

                if(freespace+result>30000000)
                {
                    System.out.println("result2"+" - "+ result2);
                    result2=Math.min(result,result2);
                    System.out.println("result2"+" - "+ result2);
                }

                int currentResult = stack.pop();
                result = currentResult + result;
            } else if (Character.isDigit(command.charAt(0))) {
                int size = Integer.parseInt(command.replaceAll("[^0-9]", ""));
                result += size;
            }
        }
        while(stack.size()>1)
        {
            int currentSpace=result+stack.pop();
            if(currentSpace+freespace>30000000)
            {
                System.out.println("result2"+" - "+ result2);
                result2=Math.min(result,result2);
            }
            int newSpace=currentSpace+stack.pop();
            stack.push(newSpace);
        }
        result2=Math.min(result2,stack.pop());
        return result2;
    }
}
//1640514

//3405360
