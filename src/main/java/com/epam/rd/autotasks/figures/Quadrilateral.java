package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    Point a, b, c, d;
    double ax, ay, bx, by, cx, cy, dx, dy;
    public Quadrilateral(Point firstSide, Point secondSide, Point thirdSide, Point fourthSide) {
        super();
        a = firstSide;
        b = secondSide;
        c = thirdSide;
        d = fourthSide;

        ax = firstSide.getX();
        ay = firstSide.getY();
        bx = secondSide.getX();
        by = secondSide.getY();
        cx = thirdSide.getX();
        cy = thirdSide.getY();
        dx = fourthSide.getX();
        dy = fourthSide.getY();
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
