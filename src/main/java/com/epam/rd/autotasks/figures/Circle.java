package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    double x, y, r;
    Point c;
    public Circle(Point center, double radius) {
        super();
        try {
            c = center;
            x = center.getX();
            y = center.getY();
            r = radius;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        if (r <= 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        return c;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        try {
            return (((Circle) figure).r == Math.round(r) && ((Circle) figure).x == Math.round(x) && ((Circle) figure).y == Math.round(y));
        } catch (ClassCastException e) {
            return false;
        }
    }
}
