package AdventOfCode;

import java.util.List;

public class AdventOfCode1 {

    public static void main(String[] args) {
       List<String> calories = ReadInput.readAOC1();
       //first question
        //System.out.println(getMaxCalories(calories));
        //second question
        System.out.println(getTop3(calories));
    }
    public static int getMaxCalories(List<String> calories)
    {
int max=Integer.MIN_VALUE;
int sum=0;
for(int i=0;i<calories.size();i++)
{
    if(calories.get(i).equals(""))
    {
        max=Math.max(max,sum);
        sum=0;
    }
    else
    {
        sum+=Integer.parseInt(calories.get(i));

    }
}
return max;
    }

    public static int getTop3(List<String> calories)
    {
        int top1=Integer.MIN_VALUE;
        int top2=Integer.MIN_VALUE;
        int top3=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<calories.size();i++)
        {
            if(calories.get(i).equals(""))
            {
                System.out.println(sum);
                if(sum>top1)
                {
                    top3=top2;
                    top2=top1;
                    top1=sum;
                }
                if(sum>top2 && sum< top1)
                {
                    top3=top2;
                    top2=sum;

                }
                else if(sum>top3 && sum < top1 && sum <top2)
                {
                    top3=sum;
                }
                sum=0;
                System.out.println(top1+" "+top2+" "+top3);
            }
            else
            {
                sum+=Integer.parseInt(calories.get(i));

            }
        }
        return top1+top2+top3;
    }

}
//200778