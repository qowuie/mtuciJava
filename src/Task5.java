import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Task5 {
    public static void main(String[] args) {
        System.out.println(hexLattice(919));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN"));
        System.out.println(numToEng(3));
        System.out.println(numToEng(18));
        System.out.println(numToEng(13));
        System.out.println(numToEng(21));
        System.out.println(numToEng(934));
        System.out.println(numToEng(999));
        System.out.println(numToEng(827));
        System.out.println(validateCard(1234567L));
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"})));
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println(canComplete("pir", "privet"));
        System.out.println(canMove("ферзь", "C1", "C8"));
        System.out.println(getSha256Hash("privet"));
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(encrypt("Hellkdlfmv..o")));

    }

    static int[] encrypt(String s){
        int[] result = new int[s.length()];
        result[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++){
            result[i] = s.charAt(i) - s.charAt(i - 1);
        }
        return result;
    }

    static String decrypt(int[] code){
        String result = "";
        result += (char) code[0];
        for (int i = 1; i < code.length; i++){
            result += (char) (code[i] + result.charAt(i - 1));
        }
        return result;
    }

    static boolean canMove(String figure, String cellFrom, String cellTo){
        int deltaLet = Math.abs(cellTo.charAt(0) - cellFrom.charAt(0));
        int deltaNum = Math.abs(cellTo.charAt(1) - cellFrom.charAt(1));
        if (figure == "пешка"){
            if (cellFrom.charAt(1) == '2' || cellFrom.charAt(1) == '7') {
                return deltaLet == 0 && deltaNum <= 2;
            }
            else {
                return deltaLet == 0 && deltaNum == 1;
            }
        }
        if (figure == "конь") return (deltaLet == 2 && deltaNum == 1) || (deltaLet == 1 && deltaNum == 2);
        if (figure == "слон") return deltaLet == deltaNum;
        if (figure == "ладья") return (deltaLet == 0 && deltaNum != 0) || (deltaLet != 0 && deltaNum == 0);
        if (figure == "ферзь") return (deltaLet == 0 && deltaNum != 0) || (deltaLet != 0 && deltaNum == 0) || (deltaLet == deltaNum);
        if (figure == "король") return (deltaLet == 1 && deltaNum == 1) || (deltaLet == 0 && deltaNum == 1) || (deltaLet == 1 && deltaNum == 0);
        return false;
    }

    static boolean canComplete(String word, String completed){
        ArrayList<String> wordChars = new ArrayList<>();
        Collections.addAll(wordChars, word.split(""));
        ArrayList<String> completedChars = new ArrayList<>();
        Collections.addAll(completedChars, completed.split(""));
        for (String ch : wordChars){
            if (completedChars.contains(ch)) completedChars.remove(ch);
            else return false;
        }
        int[] wordIndexes = new int[word.length()];
        for (int i = 0; i < word.length(); i++) wordIndexes[i] = completed.indexOf(String.valueOf(word.charAt(i)));

        int[] wordIndexesC = Arrays.copyOf(wordIndexes, wordIndexes.length);
        Arrays.sort(wordIndexes);
        return Arrays.equals(wordIndexesC, wordIndexes);
    }

    static int sumDigProd(int ... nums){
        int numsSum = 0;
        for (int i : nums) numsSum += i;
        int digProd = Integer.parseInt(String.valueOf(String.valueOf(numsSum).charAt(0)));
        for (int i = 1; i < String.valueOf(numsSum).length(); i++){
            digProd *= Integer.parseInt(String.valueOf(String.valueOf(numsSum).charAt(i)));
        }
        if (String.valueOf(digProd).length() == 1) return digProd;
        return sumDigProd(digProd);
    }

    static String[] sameVowelGroup(String[] args){
        ArrayList<String> result = new ArrayList<>();
        String vowels = "eyuioa";
        String firstVowels = "";
        for (int i = 0; i < args[0].length(); i++) {
            String c = String.valueOf(args[0].charAt(i));
            if (vowels.contains(c)) firstVowels += c;
        }
        for (String word : args){
            boolean flag = true;
            String wordVowels = "";
            for (int i = 0; i < word.length(); i++) {
                String c = String.valueOf(word.charAt(i));
                if (vowels.contains(c)) wordVowels += c;
            }
            for (int j = 0; j < wordVowels.length(); j++){
                if (!firstVowels.contains(String.valueOf(wordVowels.charAt(j)))) flag = false;
            }
            for (int y = 0; y < firstVowels.length(); y++){
                if (!wordVowels.contains(String.valueOf(firstVowels.charAt(y)))) flag = false;
            }
            if(flag) result.add(word);
        }
        return result.toArray(new String[result.size()]);
    }

    static boolean validateCard(long n){
        if (String.valueOf(n).length() < 14 || String.valueOf(n).length() > 19) return false;
        char lastDigit = String.valueOf(n).charAt(String.valueOf(n).length() - 1);
        String num = String.valueOf(n).substring(0, String.valueOf(n).length() - 1);
        String numReversed = "";
        ArrayList<Integer> doubleDigits = new ArrayList<>();
        int sum = 0;
        for (int i = num.length() - 1; i >= 0; i--) numReversed += String.valueOf(num.charAt(i));
        for (int j = 0; j < numReversed.length(); j++){
            if (j % 2 == 0){
                int doubled = Integer.parseInt(String.valueOf(numReversed.charAt(j))) * 2;
                if (String.valueOf(doubled).length() == 1) doubleDigits.add(doubled);
                else doubleDigits.add(Integer.parseInt(String.valueOf(String.valueOf(doubled).charAt(0))) + Integer.parseInt(String.valueOf(String.valueOf(doubled).charAt(1))));
            }
            else doubleDigits.add(Integer.parseInt(String.valueOf(numReversed.charAt(j))));
        }
        for (int digit : doubleDigits) sum += digit;
        return 10 - Integer.parseInt(String.valueOf(String.valueOf(sum).charAt(String.valueOf(sum).length() - 1))) == Integer.parseInt(String.valueOf(lastDigit));
    }

    static String numToEng(int num){
        String[] ones = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen"};
        String[] tens = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (num == 18) return "eighteen";
        if (num == 15) return "fifteen";
        if (num < 14) return ones[num];
        if (num < 100){
            if (Integer.parseInt(String.valueOf(String.valueOf(num).charAt(1))) == 0) return tens[Integer.parseInt(String.valueOf(String.valueOf(num).charAt(0)))];
            return tens[Integer.parseInt(String.valueOf(String.valueOf(num).charAt(0)))] + " " + ones[Integer.parseInt(String.valueOf(String.valueOf(num).charAt(1)))];
        }
        if (num < 999) return ones[Integer.parseInt(String.valueOf(String.valueOf(num).charAt(0)))] + " hundred " + numToEng(Integer.parseInt(String.valueOf(num).substring(1)));
        return "";
    }
    
    private static String getSha256Hash(String s) {
    try {
    // шифруем в байты строку через MessageDigest
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
    // переводим байты в хеш
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    } catch (Exception e) {
            return null;
        }
    }

    static String correctTitle(String s){
        String lower = "in of the and";
        String result = "";
        String[] phrase = s.split(" ");
        for (int i = 0; i < phrase.length; i++){
            if (!lower.contains(phrase[i].toLowerCase())){
                result += String.valueOf(phrase[i].charAt(0)).toUpperCase() + phrase[i].substring(1).toLowerCase();
            }
            else result += phrase[i].toLowerCase();
            if (i != phrase.length - 1) result += " ";
        }
        return result;
    }

    static String hexLattice(int n){
        double h = (3 + Math.sqrt(12 * n - 3)) / 6;
        if (h % 1 != 0) return "Invalid";
        String result = "";
        for (int i = 0; i < h; i++){
            for (int j = 0; j < h - i - 1; j++) result += " ";
            for (int m = 0;m < h + i; m++) result += "◌ ";
            result += "\n";
        }
        for (int y = (int) (h - 2); y >= 0; y--){
            for (int j = 0; j < h - y - 1; j++) result += " ";
            for (int m = 0;m < h + y; m++) result += "◌ ";
            result += "\n";
        }
        return result;
    }
}
