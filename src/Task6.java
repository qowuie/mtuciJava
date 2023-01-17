import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(bell(3));
        System.out.println(translateWord("have"));
        System.out.println(translateSentence("I like to eat honey waffles."));
    }

    public static int bell(int n) {
        int[][] Stirling = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) Stirling[i][j] = 1;
                else if (j == 0) Stirling[i][j] = 0;
                else if (j == 1) Stirling[i][j] = 1;
                else Stirling[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Stirling[i][j] = Stirling[i - 1][j - 1] + j * Stirling[i - 1][j];
            }
        }

        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += Stirling[n][i];
        }
        return result;
    }

    public static String translateWord(String word){
        if (word.length() == 0) return "";
        if (isGlas(word.charAt(0))){
            return word + "yay";
        }
        String new_s = "";
        String tmp = "";
        int save = 0;
        for (int i = 0; !isGlas(word.charAt(i)); i++){
            new_s += word.charAt(i);
            save = i;
        }
        for (int i = save + 1; i < word.length(); i++){
            tmp += word.charAt(i);
        }
        return tmp + new_s + "ay";
    }
    public static boolean isGlas(char a){
        if (a >= 'A' && a <= 'Z'){
            a += 'a' - 'A';
        }
        return a == 'a' || a == 'e' || a == 'y' || a == 'u' || a == 'i' || a == 'o';
    }
    public static String translateSentence(String sentence){
        String[] s = sentence.split(" ");
        String new_s = "";
        for (int i = 0; i < s.length; i++){
            if (s[i].charAt(s[i].length()-1) == '.' || s[i].charAt(s[i].length()-1) == ',' || s[i].charAt(s[i].length()-1) == '!' || s[i].charAt(s[i].length()-1) == '?'){
                new_s += translateWord(s[i].substring(0, s[i].length()-1));
            }
            else {
                new_s += translateWord(s[i]);
            }
            for (int j = 0; j < s[i].length(); j++){
                if (s[i].charAt(j) == '.' || s[i].charAt(j) == ',' || s[i].charAt(j) == '!' || s[i].charAt(j) == '?'){
                    new_s += s[i].charAt(j);
                }
            }
            new_s += " ";
        }
        new_s = new_s.toLowerCase();
        new_s = Character.toString(new_s.charAt(0)).toUpperCase() + new_s.substring(1);
        return new_s;
    }

    public static boolean validColor(String s){
        return s.matches("(rgb\\((\\d|\\d\\d|1\\d\\d|2[0-4][0-9]|25[0-5]),(\\d|\\d\\d|1\\d\\d|2[0-4][0-9]|25[0-5]),(\\d|\\d\\d|1\\d\\d|2[0-4][0-9]|25[0-5])\\))|(rgba\\((\\d|\\d\\d|1\\d\\d|2[0-4][0-9]|25[0-5]),(\\d|\\d\\d|1\\d\\d|2[0-4][0-9]|25[0-5]),(\\d|\\d\\d|1\\d\\d|2[0-4][0-9]|25[0-5])((,0(.[0-9]+)*)|(,1(.0)*))\\))");
    }

    public static String stripUrlParams(String s){
        if (s.indexOf("?") == -1){
            return s;
        }
        String last_s = s.substring(0, s.indexOf("?")); // без параметров
        HashMap<String, Integer> mp = new HashMap<>();
        for (int i = s.indexOf("?"); i != s.lastIndexOf("&"); i = s.indexOf("&", i + 1)){
            String new_s = s.substring(i + 1, s.indexOf("&", i + 1));
            int n;
            n = Integer.parseInt(new_s.substring(new_s.indexOf("=") + 1));
            String name;
            name = new_s.substring(0, new_s.indexOf("="));
            mp.put(name, n);
        }
        String new_s = s.substring(s.lastIndexOf("&") + 1);
        int n;
        n = Integer.parseInt(new_s.substring(new_s.indexOf("=") + 1));
        String name;
        name = new_s.substring(0, new_s.indexOf("="));
        mp.put(name, n);
        last_s += "?";
        for (String names: mp.keySet()){
            last_s += names;
            last_s += "=";
            last_s += mp.get(names);
            last_s += "&";
        }
        last_s = last_s.substring(0, last_s.length() - 1);
        return last_s;
    }


    public static String stripUrlParams(String s, String[] mass){
        if (s.indexOf("?") == -1){
            return s;
        }
        String last_s = s.substring(0, s.indexOf("?"));
        HashMap<String, Integer> mp = new HashMap<>();
        for (int i = s.indexOf("?"); i != s.lastIndexOf("&"); i = s.indexOf("&", i + 1)){
            String new_s = s.substring(i+1, s.indexOf("&", i + 1));
            int n;
            n = Integer.parseInt(new_s.substring(new_s.indexOf("=") + 1));
            String name;
            name = new_s.substring(0, new_s.indexOf("="));
            mp.put(name, n);
        }
        String new_s = s.substring(s.lastIndexOf("&") + 1);
        int n;
        n = Integer.parseInt(new_s.substring(new_s.indexOf("=") +1 ));
        String name;
        name = new_s.substring(0, new_s.indexOf("="));
        mp.put(name, n);
        last_s += "?";
        for (int i = 0; i < mass.length; i++){
            mp.remove(mass[i]);
        }
        for (String names: mp.keySet()){
            last_s += names;
            last_s += "=";
            last_s += mp.get(names);
            last_s += "&";
        }
        last_s = last_s.substring(0, last_s.length()-1);
        return last_s;
    }

    public static String[] getHashTags(String s){
        String[] new_s = s.split(" ");
        int n = Math.min(3, new_s.length);
        HashSet<String> hs = new HashSet<>();
        String max = "";
        String[] result = new String[n];
        for (int i = 0; i < n; i++){
            max = "";
            for (int j = 0; j < new_s.length; j++){
                if (max.length() < new_s[j].length() && !hs.contains(new_s[j])){
                    max = new_s[j];
                }
            }
            result[i] = max;
            hs.add(max);
        }
        for (int i = 0; i < n; i++){
            result[i] = "#" + result[i].toLowerCase();
            if(result[i].charAt(result[i].length()-1) == ',' || result[i].charAt(result[i].length()-1) == '.' || result[i].charAt(result[i].length()-1) == '!' || result[i].charAt(result[i].length()-1) == '?'){
                result[i] = result[i].substring(0, result[i].length() - 1);
            }
        }
        return result;
    }

    public static int ulam(int n){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1); a.add(2);
        for (int i = 3; a.size()-1 != n; i++){
            if(help_ulam(a, i) == 1){
                a.add(i);
            }
        }
        return a.get(n-1);
    }
    public static int help_ulam(ArrayList<Integer> arr, int target){
        HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr.size(); i++){
            if(!hs.contains(target - arr.get(i))){
                hs.add(arr.get(i));
            }
            else{
                count++;
            }
        }
        return count;
    }

    public static String longestNonrepeatingSubstring(String s){
        int ch = 128;
        if (s.length() == 0) {
            return s;
        }

        boolean[] window = new boolean[ch];

        int begin = 0, end = 0;

        for (int low = 0, high = 0; high < s.length(); high++)
        {
            if (window[s.charAt(high)])
            {
                while (s.charAt(low) != s.charAt(high))
                {
                    window[s.charAt(low)] = false;
                    low++;
                }

                low++;
            }
            else {
                window[s.charAt(high)] = true;
                if (end - begin < high - low)
                {
                    begin = low;
                    end = high;
                }
            }
        }
        return s.substring(begin, end + 1);
    }

    public static String convertToRoman(int n){
        String new_s = "";
        int a, b, c, d;
        a = n%10;
        b = n/10%10;
        c = n/100%10;
        d = n/1000%10;
        if (d <= 3){
            for (int i = 0; i < d; i++){
                new_s += "M";
            }
        }

        if (c <= 3){
            for (int i = 0; i < c; i++){
                new_s += "C";
            }
        }
        else if(c == 4){
            new_s += "CD";
        }
        else if(c > 4 && c < 9){
            new_s += "D";
            for (int i = 5; i < c; i++){
                new_s += "C";
            }
        }
        else if (c == 9) new_s += "CM";

        if (b <= 3){
            for (int i = 0; i < b; i++){
                new_s += "X";
            }
        }
        else if(b == 4) new_s += "XL";
        else if(b > 4 && b < 9){
            new_s += "L";
            for (int i = 5; i < b; i++){
                new_s += "X";
            }
        }
        else if (c == 9) new_s += "XC";
        if (a <= 3){
            for (int i = 0; i < a; i++){
                new_s += "I";
            }
        }
        else if(a == 4) new_s += "IV";
        else if(a > 4 && a < 9){
            new_s += "V";
            for (int i = 5; i < a; i++){
                new_s += "I";
            }
        }
        else if (a == 9) new_s += "IX";
        return new_s;
    }

    public static boolean formula(String s){
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i != s.lastIndexOf("="); i = s.indexOf("=", i+1)){
            String new_s = s.substring(i, s.indexOf("=", i+1));
            if (new_s.charAt(0) == '='){
                new_s = new_s.substring(2);
            }
            a.add(help_formula(new_s));
        }
        String new_s = s.substring(s.lastIndexOf("=") + 2);
        a.add(help_formula(new_s));
        for (int i = 0; i < a.size(); i++){
            if (a.get(i) - a.get(0) != 0){
                return false;
            }
        }
        return true;
    }
    public static int help_formula(String s){
        String[] new_s = s.split(" ");
        if (new_s.length == 1){
            return Integer.parseInt(new_s[0]);
        }
        else if (new_s[1].equals("*")){
            return Integer.parseInt(new_s[0]) * Integer.parseInt(new_s[2]);
        }
        else if (new_s[1].equals("/")){
            return Integer.parseInt(new_s[0]) / Integer.parseInt(new_s[2]);
        }
        else if (new_s[1].equals("+")){
            return Integer.parseInt(new_s[0]) + Integer.parseInt(new_s[2]);
        }
        else if (new_s[1].equals("-")){
            return Integer.parseInt(new_s[0]) - Integer.parseInt(new_s[2]);
        }
        return 0;
    }

    public static boolean palindromedescendant(int a){
        if(Integer.toString(a).length() == 1){
            return false;
        }
        else if(isPalindrome(a)){
            return true;
        }
        String s = Integer.toString(a);
        String new_s = "";
        for (int i = 0; i < s.length(); i += 2){
            new_s += Integer.toString(Integer.parseInt(Character.toString(s.charAt(i))) + Integer.parseInt(Character.toString(s.charAt(i + 1))));
        }
        return palindromedescendant(Integer.parseInt(new_s));

    }
    public static boolean isPalindrome(int a){
        String new_s = Integer.toString(a);
        String new_new_s = "";
        for (int i = new_s.length()-1; i >= 0; i--){
            new_new_s += new_s.charAt(i);
        }
        return a == Integer.parseInt(new_new_s);
    }
}
