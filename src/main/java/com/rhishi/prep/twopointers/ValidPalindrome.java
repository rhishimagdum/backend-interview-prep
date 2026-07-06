package main.java.com.rhishi.prep.twopointers;

public class ValidPalindrome {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String input) {
       int left = 0;
       int right = input.length() - 1;

       while (left < right ) {

           while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
               left ++;
           }

           while (left < right && !Character.isLetterOrDigit(input.charAt(right))) {
               right --;
           }
           char leftChar = input.charAt(left);
           char rightChar = input.charAt(right);

           if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
               return false;
           }

           left ++;
           right --;
       }
       return true;
    }
}