import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args){
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));
        System.out.println(findZip("---zipzip"));
        System.out.println(checkPerfect(6));
        System.out.println(flipEndChars("caff."));
        System.out.println(isValidHexCode("#01H11F"));
        System.out.println(same(new int[] {1, 2, 3}, new int[] {1, 1, 3}));
        System.out.println(isKaprekar(297));
        System.out.println(longest("00000"));
        System.out.println(nextPrime(11));
        System.out.println(rightTriangle(145, 105, 100));

    }

    static int solutions(int a, int b, int c){
        double dis = (b * b) - (4 * a * c);
        if (dis < 0) return 0;
        if (dis == 0) return 1;
        else return 2;
    }

    static int findZip(String str){
        return str.indexOf("zip", str.indexOf("zip") + 1);
    }

    static boolean checkPerfect(int a){
        int sumOfFactors = 1;
        for (int i = 2; i <= a / 2; i++){
            if (a % i == 0) sumOfFactors += i;
        }
        return sumOfFactors == a;
    }

    static String flipEndChars(String str){
        if(str.length() < 2) return "Несовместимо";
        if(str.charAt(0) == str.charAt(str.length() - 1)) return "Два это пара";
        return str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0);
    }

    static boolean isValidHexCode(String str){
        String valid = "0123456789ABCDF";
        if (str.charAt(0) == '#' && str.length() == 7){
            for (int i = 1; i < str.length(); i++){
                if(!valid.contains(String.valueOf(str.charAt(i)))) return false;
            }
            return true;
        }
        else return false;
    }

    static boolean same(int[] arr1, int[] arr2){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int j : arr1) set1.add(j);
        for (int i : arr2) set2.add(i);

        return set1.size() == set2.size();

    }

    static boolean isKaprekar(int a){
        if(a == 0 || a == 1) return true;
        if(a <= 3) return false;
        String s = Integer.toString(a * a);
        int result = Integer.parseInt(s.substring(0, s.length() / 2)) + Integer.parseInt(s.substring(s.length() / 2));
        return result == a;
    }

    static String longest(String s){
        String[] arr = s.split("1");
        String max = "";
        for(String i : arr){
            if (max.length() < i.length()) max = i;
        }
        return max;
    }

    static int nextPrime(int n){
        int i = n;
        int del = 0;
        ArrayList<Integer> primes = new ArrayList<>();
        while (i <= n + 10){
            for (int j = 2; j < Math.sqrt(i); j++){
                if (i % j == 0) del++;
            }
            if (del == 0) primes.add(i);
            i++;
            del = 0;
        }
        if (primes.contains(n)) return n;
        else return primes.get(0);
    }

    static boolean rightTriangle(int a, int b, int c){
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        return (Math.sqrt(nums[0] * nums[0] + nums[1] * nums[1]) == nums[2]);
    }





}
