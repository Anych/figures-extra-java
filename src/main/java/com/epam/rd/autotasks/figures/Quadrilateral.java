package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    Point a, b, c, d;
    double ax, ay, bx, by, cx, cy, dx, dy;
    public Quadrilateral(Point firstSide, Point secondSide, Point thirdSide, Point fourthSide) {
        super();
        try {
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
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        double firstTriangle = Math.abs((ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2);
        double secondTriangle = Math.abs((bx * (cy - dy) + cx * (dy - by) + dx * (by - cy)) / 2);
        double thirdTriangle = Math.abs((cx * (dy - ay) + dx * (ay - cy) + ax * (cy - dy)) / 2);
        double fourthTriangle = Math.abs((dx * (ay - by) + ax * (by - dy) + bx * (dy - ay)) / 2);
        if (firstTriangle == 0 || secondTriangle == 0 || thirdTriangle == 0 || fourthTriangle == 0) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public Point centroid() {
        Point firstC = new Point(((ax + bx + cx) / 3), ((ay + by + cy) / 3)); // ABC
        Point secondC = new Point(((bx + cx + dx) / 3), ((by + cy + dy) / 3)); // BCD
        Point thirdC = new Point(((cx + dx + ax) / 3), ((cy + dy + ay) / 3)); // ACD
        Point fourthC = new Point(((dx + ax + bx) / 3), ((dy + ay + by) / 3)); // ABD

        double a1 = thirdC.getY() - firstC.getY();
        double b1 = firstC.getX() - thirdC.getX();
        double c1 = a1 * firstC.getX() + b1 * firstC.getY();

        double a2 = fourthC.getY() - secondC.getY();
        double b2 = secondC.getX() - fourthC.getX();
        double c2 = a2 * secondC.getX() + b2 * secondC.getY();

        double delta1 = a1 * b2 - a2 * b1;

        return new Point((b2 * c1 - b1 * c2) / delta1, (a1 * c2 - a2 * c1) / delta1);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }

}
