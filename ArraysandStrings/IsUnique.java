package ArraysandStrings;

import java.util.Arrays;

public class IsUnique {

    public static void main(String[] args)
    {
        String s="srvya";

        if(isUnique(s)){
        System.out.println("String "+ s+" " + "has unique characters");}
        else{
            System.out.println("String "+ s+" " + "has duplicate characters");}
    }

    public static boolean isUnique(String s)
    {
        boolean[] chars=new boolean[128];
        Arrays.fill(chars,false);

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);

            if(chars[c])
            {
                return false;
            }
            if(!chars[c])
            {
                chars[c]=true;
            }
        }
        return true;
    }
}
