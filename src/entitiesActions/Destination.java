package entitiesActions;

public class Destination {
    private double X;
    private double Z;
    private double length;
    private long id;

    public Destination(double x, double z, double length, long id) {
        X = x;
        Z = z;
        this.length = length;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "X=" + X +
                ", Z=" + Z +
                ", length=" + length +
                ", attacked creature=" + id +
                '}';
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getZ() {
        return Z;
    }

    public void setZ(double z) {
        Z = z;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public void setId(long attacked) {
        this.id = id;
    }
}
