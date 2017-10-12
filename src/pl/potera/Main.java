package pl.potera;

import pl.potera.patterns.Grid;
import pl.potera.patterns.Ring;

public class Main {

    public static void main(String[] args) {

        int x_res = 400, y_res = 400;
        new Ring(x_res, y_res, 20, 2);
        new Grid(x_res, y_res, 50);

    }
}
