package ArraysandStrings;

public class CheckPermutation {

    public static void main(String[] args) {
        String s1 = "sravya";
        String s2 = "ayvarr";

        if (checkPermutation(s1, s2)) {
            System.out.println("String " + s1 + " " + "is a Permutation of " + "String " + s2);
        } else {
            System.out.println("String " + s1 + " " + "is not a Permutation of " + "String " + s2);
        }
    }

    public static boolean checkPermutation(String s1, String s2) {

        int[] chars = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            chars[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (chars[c] <= 0) {
                return false;
            } else {
                chars[c]--;
            }

        }
        return true;
    }
}
