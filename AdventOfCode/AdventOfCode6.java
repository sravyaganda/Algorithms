package AdventOfCode;

import java.util.List;

public class AdventOfCode6 {

    public static void main(String[] args) {
       String datastream = ReadInput.readAOC6();
       //String datastream="bvwbjplbgvbhsrlpgdmjqwftvncz";
       System.out.println(datastream);
        //System.out.println(intervals.size());
        System.out.println(getSum1(datastream));
        // System.out.println(getSum2(intervals));

    }

    public static int getSum1(String datastream)
    {
        int index=0;
        int[] letters=new int[26];
        int left=0;
        int right=0;

        while(right< datastream.length())
        {
            //zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw
            char c=datastream.charAt(right);
            System.out.println(c);
            while(letters[c-'a']>0)
            {
                letters[datastream.charAt(left)-'a']--;
                left++;
            }
            letters[c-'a']++;
            right++;
            if(right-left==14)
            {
                index=right;
                break;
            }
        }

      return index;
    }
}
