public class Task2 {
    public static void main(String[] args){
        System.out.println(repeat("java", 3));
        System.out.println(differenseMaxMin(new int[] {1, 2, 3}));
        System.out.println(isAvgWhole(new int[] {1, 2, 3, 4}));
        System.out.println("--------------");
        for (int i : cumulativeSum(new int[] {1, 2, 3}))
            System.out.println(i);
        System.out.println("--------------");
        System.out.println(getDecimalPlaces("400.234"));
        System.out.println(fibbonacci(12));
        System.out.println(isValid("12345"));
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isPrefix("pavel", "pav-"));
        System.out.println(isSuffix("pavel", "-vel"));
        System.out.println(boxSeq(7));
    }

    public static String repeat(String s, int n){
        String result = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < n; j++){
                result += s.charAt(i);
            }
        }
        return result;
    }

    public static int differenseMaxMin(int[] array){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : array){
            if(i < min) min = i;
        }

        for(int i : array){
            if(i > max) max = i;
        }

        return max - min;
    }

    public static boolean isAvgWhole(int[] array){
        double s = 0;
        for (int i : array){
            s += i;
        }
        return s / array.length == Math.round(s / array.length);
    }

    public static int[] cumulativeSum(int[] array){
        int s = 0;
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i] + s;
            s += array[i];
        }
        return result;
    }

    public static int getDecimalPlaces(String s){
        if (s.indexOf('.') != -1) {
            return s.length() - s.indexOf('.') - 1;
        }
        else return 0;
    }

    public static int fibbonacci(int a){
        int a1 = 0;
        int a2 = 1;
        int a3 = 0;
        for (int i =0; i<a;i++){
            a3 = a2+a1;
            a1 = a2;
            a2 = a3;
        }
        return a3;
    }

    public static boolean isValid(String a){
        String s = "1234567890";
        if (a.length() <= 5) {
            for (int i = 0; i < a.length(); i++) {
                if (s.indexOf(a.charAt(i)) == -1){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isStrangePair(String a, String b){
        if (a.equals("")&&b.equals("")) return true;
        if (a.equals("")||b.equals("")) return false;
        return a.charAt(0) == b.charAt(b.length() - 1) && b.charAt(0) == a.charAt(a.length() - 1);
    }

    public static boolean isPrefix(String a, String b){
        for (int i = 0; i < b.length() - 1; i++){
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static boolean isSuffix(String a, String b){
        for (int i = 0; i < b.length() - 1;i++){
            if (a.charAt(a.length() - i - 1) != b.charAt(b.length() - i - 1)) return false;
        }
        return true;
    }

    public static int boxSeq(int a){
        if (a == 0) return 0;
        if (a % 2 == 0) return a;
        else return a + 2;
    }

}
