package com.epam.rd.autotasks.figures;

class Circle  extends Figure {
    double x, y, r;
    Point c;
    public Circle(Point center, double radius) {
        super();
        c = center;
        x = center.getX();
        y = center.getY();
        r = radius;
    }

    @Override
    public Point centroid() {
        return c;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }
}
