package AdventOfCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventOfCode2 {

    public static void main(String[] args) {
        List<String> strategy = ReadInput.readAOC2();
        //System.out.println(getScores(strategy));
        System.out.println(getelfScores(strategy));

    }

    public static int getScores(List<String> strategy)
    {
        int totalScore=0;
        Map<Character,Integer> opp=new HashMap<>();
        opp.put('A',1); //rock
        opp.put('B',2); //paper
        opp.put('C',3); //scissor
        Map<Character,Integer> self=new HashMap<>();
        self.put('X',1);
        self.put('Y',2);
        self.put('Z',3);
        for(int i=0;i<strategy.size();i++)
        {
            String game=strategy.get(i);
            char opp1=game.charAt(0);
            char self1=game.charAt(2);
           if(self1=='X'&& opp1=='C')
           {
               int score=self.get(self1);
               totalScore+=score+6;
               System.out.println(totalScore);
               continue;
           }
           else if(self1=='Z'&& opp1=='A')
           {
                   int score=self.get(self1);
                   totalScore+=score;
                   System.out.println(totalScore);
               continue;
           }
          else if(opp.get(opp1)==self.get(self1))
            {
                int score=self.get(self1);
                totalScore+=score+3;
                System.out.println(totalScore);
                continue;
            }
           else if(opp.get(opp1)<self.get(self1))
            {
                int score=self.get(self1);
                totalScore+=score+6;
                System.out.println(totalScore);
                continue;
            }
            else if(opp.get(opp1)>self.get(self1))
            {
                int score=self.get(self1);
                totalScore+=score;
                System.out.println(totalScore);
                continue;
            }
        }
        return totalScore;
    }
//The Elf finishes helping with the tent and sneaks back over to you. "Anyway,
// the second column says how the round needs to end: X means you need to lose,
// Y means you need to end the round in a draw, and Z means you need to win. Good luck!"
    public static int getelfScores(List<String> strategy)
    {

        int totalScore=0;
        Map<Character,Integer> opp=new HashMap<>();
        opp.put('A',1); //rock
        opp.put('B',2); //paper
        opp.put('C',3); //scissor
        Map<Character,Integer> self=new HashMap<>();
        self.put('X',-1);
        self.put('Y',1);
        self.put('Z',2);
        for(int i=0;i<strategy.size();i++) {
            String game = strategy.get(i);
            char opp1 = game.charAt(0);
            char self1 = game.charAt(2);
            //X -lose,Y-DRAW,Z-WIN
            if(self1=='X')
            {
              int score=0;
              if(opp1=='A')
              {
                  score=3;
              }
              else
              {
                  score=opp.get(opp1)-1;
              }
              totalScore+=score;
            }
            else if(self1=='Y')
            {
                totalScore+=opp.get(opp1)+3;
            }
            else if(self1=='Z')
            {
                int score=0;
                if(opp1=='C')
                {
                    score=1;
                }
                else
                {
                    score=opp.get(opp1)+1;
                }
                totalScore+=score+6;
            }

        }

            return totalScore;
    }
}
