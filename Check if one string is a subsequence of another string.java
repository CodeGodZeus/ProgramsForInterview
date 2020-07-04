//Check if one string is a subsequence of another string.
*/Approach: 

Given strings, A and B.
Check if any of the string is null, return false.
Compare the lengths of both the strings 
do String longer = A or B, whichever is longer than other.
do String shorter = A or B, whichever is shorter than other.
Now have two strings, longer and shorter. We know only a shorter string can be a subsequence of a longer string, whereas vice versa is not true.
Initialize the starting index for the shorter string as j = 0.
Iterate the longer string and for current index i
If the character at index i in longer is the same as the character at index j in shorter. If yes then do j++.
After iteration, if j==length of shorter means is subsequence in longer string, return true else return false. 
Run This Code

Complete Code:/*

public class CheckIfOneStringIsSubsequenceOfAnother {

    public static boolean checkSubSequence(String A, String B){
        if(A==null || B==null)
            return false;

        String longer = A.length()>B.length() ? A : B;
        String shorter = A.length()<=B.length() ? A : B;

        int j = 0;
        for (int i = 0; i < longer.length() && j < shorter.length(); i++) {
            if (longer.charAt(i) == shorter.charAt(j))
                j++;
        }

        //check if all are matched
        if(j==shorter.length())
            return true;

        return false;
    }

    public static void main(String[] args) {
        String A = "horizon";
        String B = "abhordizaonr";
        System.out.println(checkSubSequence(A, B));
        System.out.println(checkSubSequence(B, A));
    }
}
