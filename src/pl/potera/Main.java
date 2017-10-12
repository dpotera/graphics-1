package pl.potera;

import pl.potera.patterns.Grid;
import pl.potera.patterns.Ring;

public class Main {

    public static void main(String[] args) {

        int x_res = 100, y_res = 100;
        new Ring(x_res, y_res, 20, 10);
        new Grid(x_res, y_res, 10, 10, 50, 30);

    }
}
