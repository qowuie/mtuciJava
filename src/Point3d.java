public class Point3d extends Point2d {
    private double zCoord;


    public Point3d(double x, double y, double z){
        super(x, y);
        zCoord = z;
    }

    public Point3d(){
        this(0, 0, 0);
    }

    public double getZ(){
        return zCoord;
    }

    public void setZ(double newZ){
        zCoord = newZ;
    }

    public boolean isEqual(Point3d obj){
        return (this.getX() == obj.getX()) && (this.getY() == obj.getY()) && (this.getZ() == obj.getZ());
    }

    public double distanceTo(Point3d obj){
        double distance = Math.sqrt(Math.pow(obj.getX() - this.getX(), 2) + Math.pow(obj.getY() - this.getY(), 2)
                + Math.pow(obj.getZ() - this.getZ(), 2));
        double scale = Math.pow(10, 2);
        return Math.ceil(distance * scale) / scale;
    }

}
