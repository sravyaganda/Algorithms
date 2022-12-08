package AdventOfCode;

import java.util.*;

public class AdventOfCode3 {

    public static void main(String[] args) {
        List<String> patterns = ReadInput.readAOC3();

        //System.out.println(getSum(patterns));
       System.out.println(getSum2(patterns));


    }

    public static int getSum(List<String> patterns) {
        int totalScore = 0;
        for (int i = 0; i < patterns.size(); i++) {
            String s = patterns.get(i);
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                if (j < s.length() / 2) {
                    set.add(s.charAt(j) - 0);
                } else if (j >= s.length() / 2 && set.contains(s.charAt(j) - 0)) {
                    if (Character.isLowerCase(s.charAt(j))) {
                        totalScore += (s.charAt(j) - 'a') + 1;
                        break;
                    } else {
                        totalScore += (s.charAt(j) - 'A') + 27;
                        break;
                    }
                }
            }
        }
        return totalScore;
    }

    public static int getSum2(List<String> patterns) {
        int totalScore = 0;
        for (int i = 0; i < patterns.size()/3; i++) {

            List<HashSet<Character>> list=new ArrayList<>();
            String firstString="";
            boolean isfirst=true;
            for(int j=i*3;j<(i*3)+3;j++){
                if(isfirst)
                {
                    firstString=patterns.get(j);
                    isfirst=false;
                }
                HashSet<Character> set1=new HashSet<>();
                for(Character c:patterns.get(j).toCharArray())
                {
                    set1.add(c);
                }
                list.add(set1);
            }

            for(Character c:firstString.toCharArray())
            {
                if(list.get(1).contains(c)&& list.get(2).contains(c))
                {
                    if (Character.isLowerCase(c) ){
                        totalScore += (c - 'a') + 1;
                        break;
                    } else {
                        totalScore += (c - 'A') + 27;
                        break;
                    }
                }
            }

        }
        return totalScore;
    }
}
