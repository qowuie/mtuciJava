import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение X для первой точки: ");
        double point1X = scanner.nextDouble();
        System.out.println("Введите значение Y для первой точки: ");
        double point1Y = scanner.nextDouble();
        System.out.println("Введите значение Z для первой точки: ");
        double point1Z = scanner.nextDouble();
        System.out.println("Введите значение X для второй точки: ");
        double point2X = scanner.nextDouble();
        System.out.println("Введите значение Y для второй точки: ");
        double point2Y = scanner.nextDouble();
        System.out.println("Введите значение Z для второй точки: ");
        double point2Z = scanner.nextDouble();
        System.out.println("Введите значение X для третьей точки: ");
        double point3X = scanner.nextDouble();
        System.out.println("Введите значение Y для третьей точки: ");
        double point3Y = scanner.nextDouble();
        System.out.println("Введите значение Z для третьей точки: ");
        double point3Z = scanner.nextDouble();

        Point3d point1 = new Point3d(point1X, point1Y, point1Z);
        Point3d point2 = new Point3d(point2X, point2Y, point2Z);
        Point3d point3 = new Point3d(point3X, point3Y, point3Z);

        if(point1.isEqual(point2)) {
            System.out.println("Первая точка равна второй, площадь не будет посчитана");
        }
        else if(point1.isEqual(point3)) {
            System.out.println("Первая точка равна третьей, площадь не будет посчитана");
        }
        else if(point2.isEqual(point3)) {
            System.out.println("Вторая точка равно третьей, площадь не будет посчитана");
        }
        else {
            System.out.println(computeArea(point1, point2, point3));
        }


    }

    public static double computeArea(Point3d point1, Point3d point2, Point3d point3){
        double a = point1.distanceTo(point2);
        double b = point2.distanceTo(point3);
        double c = point3.distanceTo(point1);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
