import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Task4 {
    public static void main(String[] args) {
        bessy(10, 7, "hello my name is Bessey and this is my essay");
        System.out.println(Arrays.toString(bracket("((()))()()()((()))(()())()")));
        System.out.println(toCamelCase("get_color"));
        System.out.println(toSnakeCase("getColor"));
        System.out.println(overTime(new double[]{16, 18, 30, 1.8}));
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(bugger(39));
        System.out.println(toStarShorthand("aaaabbc"));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(trouble(1222345, 12345));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
    }

    static void bessy(int n, int k, String essay) {
        String[] words = essay.split(" ");
        String result = "";
        int len = 0; // количество именно букв
        for (String i : words) {
            if (k - len >= i.length()) { // если осталось символов в строке больше чем длина слова, то можно записать это слово
                result += i + " ";
                len += i.length();
            } else {
                System.out.println(result.substring(0, result.length() - 1));
                result = i + " ";
                len = i.length();
            }
        }
        System.out.println(result.substring(0, result.length() - 1));
    }

    static String[] bracket(String s) {
        int opened = 0;
        int closed = 0;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') opened++;
            if (s.charAt(i) == ')') closed++;
            if (closed == opened) {
                result.add(s.substring(i - opened - closed + 1, i + 1));
                opened = 0;
                closed = 0;
            }
        }
        return result.toArray(new String[result.size()]);
    }

    static String toSnakeCase(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String ch = Character.toString(s.charAt(i));
            if (ch.equals(ch.toUpperCase())) result += "_";
            result += ch.toLowerCase();
        }
        return result;
    }

    static String toCamelCase(String s) {
        String[] array = s.split("_");
        String result = array[0];
        for (int i = 1; i < array.length; i++) {
            result += String.valueOf(array[i].charAt(0)).toUpperCase() + array[i].substring(1);
        }
        return result;
    }

    static String overTime(double[] args) {
        double start = args[0];
        double finish = args[1];
        double bet = args[2];
        double x = args[3];
        String result;

        if (finish > 17) {
            double under = 17 - start;
            double over = finish - 17;
            result = String.format("$%s", under * bet + over * bet * x);
        } else {
            double under = finish - start;
            result = String.format("$%s", under * bet);
        }
        return result;
    }

    static String BMI(String arg1, String arg2) {
        String[] w = arg1.split(" ");
        String[] h = arg2.split(" ");
        double weight = 0;
        double height = 0;

        if (w[1].equals("pounds")) weight = Integer.parseInt(w[0]) / 2.205;
        else weight = Integer.parseInt(w[0]);

        if (h[1].equals("inches")) height = Integer.parseInt(h[0]) / 39.37;
        else height = Integer.parseInt(h[0]);

        double bmi = weight / (height * height);

        if (bmi < 18.5) return String.format("%.1f Underweight", bmi);
        if (18.5 <= bmi && bmi < 25) return String.format("%.1f Normal weight", bmi);
        if (bmi > 25) return String.format("%.1f Overweight", bmi);
        else return "";
    }

    static int bugger(int num) {
        if (String.valueOf(num).length() == 1) return 0;
        int result = 1;
        int multi = 1;
        for (int i = 0; i < String.valueOf(num).length(); i++) {
            multi *= Integer.parseInt(String.valueOf(String.valueOf(num).charAt(i)));
        }

        while (String.valueOf(multi).length() != 1) {
            int newmulti = 1;
            for (int i = 0; i < String.valueOf(multi).length(); i++) {
                newmulti *= Integer.parseInt(String.valueOf(String.valueOf(multi).charAt(i)));
            }
            multi = newmulti;
            result += 1;
        }
        return result;
    }

    static String toStarShorthand(String s) {
        String result = "";
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            String prev = String.valueOf(s.charAt(i - 1)); // предыдущий символ
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (count == 1) result += prev;
                else result += String.format("%s*%s", prev, count);
                if (i == s.length() - 1) result += String.valueOf(s.charAt(i));
                count = 1;
            } else {
                count++;
                if (i == s.length() - 1)
                    result += String.format("%s*%s", prev, count);
            }
        }
        return result;
    }

    static boolean doesRhyme(String w1, String w2){
        String vowels = "eyuioa";
        String[] arr1 = w1.split(" ");
        String[] arr2 = w2.split(" ");
        String word1 = arr1[arr1.length - 1].toLowerCase();
        String word2 = arr2[arr2.length - 1].toLowerCase();
        boolean result = true;
        for (int i = 0; i < word1.length(); i++) {
            String letter = String.valueOf(word1.charAt(i));
            if (vowels.contains(letter) && !word2.contains(letter)) result = false;
        }

        for (int j = 0; j < word2.length(); j++){
            String letter1 = String.valueOf(word2.charAt(j));
            if (vowels.contains(letter1) && !word1.contains(letter1)) result = false;
        }

        return result;
    }

    static boolean trouble(int a, int b){
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);
        boolean result = false;
        for (int i = 0; i < sa.length(); i++){
            String num1 = sa.charAt(i) + String.valueOf(sa.charAt(i));
            if (sa.contains(num1 + sa.charAt(i)) && sb.contains(num1)) result = true;
        }
        return result;
    }

    static int countUniqueBooks(String s, char ch){
        boolean flag = false;
        HashSet<Character> count = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ch){
                flag = !flag;
                continue;
            }
            if (flag) count.add(s.charAt(i));
        }
        return count.size();
    }

}
