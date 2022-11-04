package ArraysandStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsUnique {

    public static void main(String[] args) {

List<String> s=new ArrayList<>() ;
s.add("azbde");
s.add("abcher");
s.add("acegk");
int m=3;
System.out.println(solve(2,s));
    }


    public static String solve(int m, List<String> s) {

       long sum=0;
       long div=2;
        for(int i=0;i<s.size();i++)
        {
            String str=s.get(i);
            long product=1;

            for(char c:str.toCharArray())
            {
                int cValue=c;
                product*=(int) Math.pow(cValue,m);
            }
           System.out.println(product);
            sum+=product;
        }

        System.out.println(sum%div);
        if(sum%div==0)
        {
            return "EVEN";
        }
        else
        {
            return "ODD";
        }

    }


}
