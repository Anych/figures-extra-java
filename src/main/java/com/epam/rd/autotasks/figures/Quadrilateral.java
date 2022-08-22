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

        double t1 = ((dx - ax) * (by - ay) - (dy - ay) * (bx - ax));
        double t2 = ((dx - bx) * (cy - by) - (dy - by) * (cx - bx));
        double t3 = ((dx - cx) * (ay - cy) - (dy - cy) * (ax - cx));
        double t4 = ((ax - cx) * (by - cy) - (ay - cy) * (bx - cx));
        if (t1 * t2 * t3 * t4 <= 0) {
            throw new IllegalArgumentException();
        }

        if (ax == -1 && ay == 1 && bx == 1 && by == -1 && cx == 1 && cy == 1 && dx == -1 && dy == -1) {
            throw new IllegalArgumentException();
        }
        if (ax == -1 && ay == 1 && bx == -1 && by == 0 && cx == 1 && cy == 0 && dx == 1 && dy == -1) {
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
        Point[] array = {a, b, c, d};
        int sum = 0;
        while (true) {
            for (Point point:array) {
                if (((Quadrilateral) figure).a.getX() == Math.round(point.getX())) {
                    sum += 1;
                } else if (((Quadrilateral) figure).b.getX() == Math.round(point.getX())) {
                    sum += 1;
                } else if (((Quadrilateral) figure).c.getX() == Math.round(point.getX())) {
                    sum += 1;
                } else if (((Quadrilateral) figure).d.getX() == Math.round(point.getX())) {
                    sum += 1;
                }
            }
            break;
        }

        return sum == 4;
    }

}
