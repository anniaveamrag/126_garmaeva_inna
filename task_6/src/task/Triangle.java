package task;

public class Triangle {
    private double A;
    private double B;
    private double C;
    public Triangle(double A, double B, double C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    public double getA() {
        return A; }
    public double getB() {
        return B; }
    public double getC() {
        return C; }
    public boolean isValid() {
        if (A + B <= C)
            return false;
        if (A + C <= B)
            return false;
        if (B + C <= A)
            return false;
        return true;
    }
    public double perimeter() {
    if (!(this.isValid()))
        return -1;
    return (A + B + C);
    }
    public double square() {
        if (!(this.isValid()))
            return -1;
        double P = this.perimeter() / 2;
        return Math.sqrt(P * (P - A) * (P - B) * (P - C)); }
    }
