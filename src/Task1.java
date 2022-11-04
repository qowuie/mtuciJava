public class Task1 {
    public static void main(String[] args) {
        System.out.println(remainder(1, 3));
        System.out.println(triArea(10, 10));
        System.out.println(animals(5, 2, 8));
        System.out.println(profitableGamble(0.9, 1, 2));
        System.out.println(operation(4, 2, 2));
        System.out.println(ctoa('['));
        System.out.println(addUpTo(10));
        System.out.println(abcmath(42, 5, 10));
    }

    public static int remainder(int x, int y){
        return x % y;
    }

    public static double triArea(int a, int h){
        return 0.5 * a * h;
    }

    public static int animals(int ch, int cows, int pigs){
        return 2 * ch + 4 * (cows + pigs);
    }

    public static boolean profitableGamble(double prob, double prize, double pay){
        return prob * prize > pay;
    }

    public static String operation(int n, int a, int b){
        if (a + b == n) return "added";
        else if (a - b == n) return "subtracted";
        else if (a * b == n) return "multiplied";
        else if (a / b == n) return "divided";
        else return "none";
    }

    public static int ctoa(char a){
        return (int) a;
    }

    public static int addUpTo(int a){
        int result = 0;
        for(int x = a; x > 0; x--){
            result += x;
        }
        return result;
    }

    public static int nextEdge(int a, int b){
        return a + b - 1;
    }

    public static int sumOfCubes(int[] array){
        int result = 0;
        for (int x : array){
            result += x ^ 3;
        }
        return result;
    }

    public static boolean abcmath(int a, int b, int c){
        int result = a;
        for (int x = 0; x < b; x++){
            result += result;
        }
        if (result % c == 0) return true;
        else return false;
    }

}
