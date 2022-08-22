package com.epam.rd.autotasks.figures;

public class Main {
    public static void main(String[] args) {

        Quadrilateral q = new Quadrilateral(new Point(1, 1), new Point(1, -1), new Point(-1, -1), new Point(-1, 1));
        System.out.println(q.centroid());

    }
}
