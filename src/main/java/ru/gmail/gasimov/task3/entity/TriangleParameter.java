package ru.gmail.gasimov.task3.entity;


public class TriangleParameter {
    private double area;
    private double perimeter;

    public TriangleParameter(double square, double perimeter) {
        this.area = square;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TriangleParameter parameters = (TriangleParameter) obj;

        return perimeter == parameters.perimeter
                && area == parameters.area;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + Double.hashCode(area);
        result = result * prime + Double.hashCode(perimeter);

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriangleParameter{");
        sb.append("area=").append(area);
        sb.append(", perimeter=").append(perimeter);
        sb.append('}');
        return sb.toString();
    }
}
