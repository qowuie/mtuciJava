public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }
    public static String reverseString(String s){
        String result = "";
        for(int index = s.length() - 1; index >= 0; index--){
            result += String.valueOf(s.charAt(index));
        }
        return result;
    }

    public static boolean isPalindrome(String s){
        return s.equals(reverseString(s));
    }
}
