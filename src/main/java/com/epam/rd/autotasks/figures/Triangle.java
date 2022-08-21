package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    Point a, b, c;
    double ax, ay, bx, by, cx, cy;
    public Triangle(Point firstSide, Point secondSide, Point thirdSide) throws IllegalArgumentException {
        super();
        try {
            a = firstSide;
            b = secondSide;
            c = thirdSide;

            ax = firstSide.getX();
            ay = firstSide.getY();
            bx = secondSide.getX();
            by = secondSide.getY();
            cx = thirdSide.getX();
            cy = thirdSide.getY();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        if (Math.abs((ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2) == 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        return new Point(((ax + bx + cx) / 3), ((ay + by + cy) / 3));
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }
}
