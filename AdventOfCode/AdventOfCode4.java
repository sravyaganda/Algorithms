package AdventOfCode;

import java.util.List;

public class AdventOfCode4 {
    public static void main(String[] args) {
        List<String> intervals = ReadInput.readAOC4();
        //System.out.println(intervals.size());
        System.out.println(getSum1(intervals));
       // System.out.println(getSum2(intervals));
    }

    public static int getSum1(List<String> intervals)
    {
        int total=0;

        for(int i=0;i<intervals.size();i++)
        {
            String[] interval=intervals.get(i).split(",",-1);
            String[] firstInterval=interval[0].split("-");
            String[] secondInterval=interval[1].split("-");

            int num11=Integer.parseInt(firstInterval[0]);
            int num12=Integer.parseInt(firstInterval[1]);
            int num21=Integer.parseInt(secondInterval[0]);
            int num22=Integer.parseInt(secondInterval[1]);

           // System.out.println(num11+" - "+num12+" - "+num21+" - "+num22);
            if((num11<=num21 && num12>=num22)||(num11>=num21 && num12<=num22)|| (num12>=num21&& num12<=num22)||(num22>=num11&& num22<=num12))
            {
               System.out.println("ANS"+ "- "+num11+" - "+num12+" - "+num21+" - "+num22);
                total++;
            }
        }
return total;
    }
}
