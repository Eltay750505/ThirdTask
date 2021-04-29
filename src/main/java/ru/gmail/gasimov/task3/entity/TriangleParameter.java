package ru.gmail.gasimov.task3.entity;


public class TriangleParameter {
    private double square;
    private double perimeter;

    public TriangleParameter(double square, double perimeter) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
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
                && square == parameters.square;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + Double.hashCode(square);
        result = result * prime + Double.hashCode(perimeter);

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriangleParameter{");
        sb.append("square=").append(square);
        sb.append(", perimeter=").append(perimeter);
        sb.append('}');
        return sb.toString();
    }
}
