public class Point3d {
    private double xCoord;
    private double yCoord;
    private double zCoord;

    public Point3d(double x, double y, double z){
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Point3d(){
        this(0, 0, 0);
    }

    public double getX(){
        return xCoord;
    }
    public double getY(){
        return yCoord;
    }
    public double getZ(){
        return zCoord;
    }

}
